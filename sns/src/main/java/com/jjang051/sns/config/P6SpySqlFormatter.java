package com.jjang051.sns.config;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.hibernate.engine.jdbc.internal.FormatStyle;

import java.util.Locale;

public class P6SpySqlFormatter implements MessageFormattingStrategy {

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

        return String.format(
                """

==================================================
실행시간 : %d ms
카테고리 : %s

%s
==================================================
""",
                elapsed,
                category,
                formatSql(category, sql)
        );
    }

    private String formatSql(String category, String sql) {

        if (!"statement".equals(category)) {
            return sql;
        }

        String lowerSql = sql.trim().toLowerCase(Locale.ROOT);

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
}