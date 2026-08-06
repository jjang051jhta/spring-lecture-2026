package com.jjang051.reactmember.config;


import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.hibernate.engine.jdbc.internal.FormatStyle;

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
        if (sql == null || sql.isBlank()) {
            return "";
        }

        String formattedSql;

        if ("statement".equals(category)) {
            formattedSql = FormatStyle.BASIC
                    .getFormatter()
                    .format(sql);
        } else {
            formattedSql = sql;
        }

        return String.format(
                "%n실행 시간: %dms%n분류: %s%nSQL:%n%s",
                elapsed,
                category,
                formattedSql
        );
    }
}