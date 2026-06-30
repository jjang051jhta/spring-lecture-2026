package com.jjang051.security.config;

import com.jjang051.security.member.dao.MemberDao;
import com.jjang051.security.member.service.OAuth2DetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final OAuth2DetailsService oauth2DetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth->
                        auth
                                .requestMatchers(
                                        "/",
                                                "/main",
                                                "/member/login",
                                                "/member/signup",
                                                "/member/find-password",
                                                "/member/reset-password",
                                                "/member/find-password/send",
                                                "/member/find-password/verify",
                                                "/mail/**",
                                                "/map/**",
                                                "/map/ev-car",
                                                "/redis/**",
                                                "/images/**",
                                                "/css/**",
                                                "/js/**"
                                ).permitAll()
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .csrf(csrf->csrf.disable())
//                .csrf(csrf -> csrf
//                        .ignoringRequestMatchers(
//                                "/mail/**",
//                                "/member/find-password/send",
//                                "/member/find-password/verify")
//                )
                .formLogin(form->
                        form
                                .loginPage("/member/login")          //get
                                .loginProcessingUrl("/member/login") //post
                                .defaultSuccessUrl("/",true)
                                .usernameParameter("userId")
                                .passwordParameter("userPw")
                                .failureUrl("/member/login?error=true")
                        .permitAll()
                )
                .oauth2Login(oauth2->{
                    oauth2
                            .loginPage("/member/login")
                            .defaultSuccessUrl("/",true)
                            .userInfoEndpoint(userInfo->{
                                userInfo.userService(oauth2DetailsService);
                            });
                })
                .logout(logout ->
                        logout
                                .logoutUrl("/member/logout")
                                .logoutSuccessUrl("/")
                );
        return http.build();
    }
}
