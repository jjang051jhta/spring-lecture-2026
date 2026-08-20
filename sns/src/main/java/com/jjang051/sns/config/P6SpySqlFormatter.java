package com.jjang051.sns.config;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.hibernate.engine.jdbc.internal.FormatStyle;

import java.util.Locale;

public class P6SpySqlFormatter implements MessageFormattingStrategy {

    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";

    @Override
    public String formatMessage(
            int connectionId,
            String now,
            long elapsed,
            String category,
            String prepared,
            String sql,
            String url
    ) {

        if (sql == null || sql.trim().isEmpty()) {
            return "";
        }

        String formattedSql = formatSql(category, sql);
        String coloredSql = colorSql(formattedSql);

        return String.format(
                """

                %s==================================================%s
                %s실행시간%s : %d ms
                %s카테고리%s : %s

                %s
                %s==================================================%s
                """,
                CYAN,
                RESET,

                YELLOW,
                RESET,
                elapsed,

                YELLOW,
                RESET,
                category,

                coloredSql,

                CYAN,
                RESET
        );
    }

    private String formatSql(String category, String sql) {

        if (!"statement".equals(category)) {
            return sql;
        }

        String lowerSql = sql
                .trim()
                .toLowerCase(Locale.ROOT);

        if (lowerSql.startsWith("create")
                || lowerSql.startsWith("alter")
                || lowerSql.startsWith("drop")
                || lowerSql.startsWith("comment")) {

            return FormatStyle.DDL
                    .getFormatter()
                    .format(sql);
        }

        return FormatStyle.BASIC
                .getFormatter()
                .format(sql);
    }

    private String colorSql(String sql) {

        return sql
                // SELECT 계열
                .replaceAll(
                        "(?i)\\b(select|from|where|order by|group by|having|join|left join|right join|inner join|on|as)\\b",
                        BLUE + "$1" + RESET
                )

                // INSERT / UPDATE / DELETE
                .replaceAll(
                        "(?i)\\b(insert|into|values|update|set|delete)\\b",
                        GREEN + "$1" + RESET
                )

                // 기타 키워드
                .replaceAll(
                        "(?i)\\b(and|or|not|null|is|in|like|asc|desc)\\b",
                        YELLOW + "$1" + RESET
                );
    }
}