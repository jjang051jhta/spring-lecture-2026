package com.jjang051.sns.config;

import com.p6spy.engine.spy.P6SpyOptions;
import jakarta.annotation.PostConstruct;

public class P6SpyConfig {
    @PostConstruct
    public void setMessageFormat() {
        P6SpyOptions.getActiveInstance().setLogMessageFormat(P6SpySqlFormatter.class.getName());
    }
}
