package com.goit.utils;

import org.flywaydb.core.Flyway;

public class FlywayRunner {

    private static final String URL_KEY = "hibernate.connection.url";
    private static final String USERNAME_KEY = "hibernate.connection.username";
    private static final String PASSWORD_KEY = "hibernate.connection.password";

    private FlywayRunner() {
    }

    public static void flywayMigration() {
        var flyway = Flyway.configure()
                .dataSource(PropertiesUtil.get(URL_KEY),
                            PropertiesUtil.get(USERNAME_KEY),
                            PropertiesUtil.get(PASSWORD_KEY))
                .load();
        flyway.migrate();
    }
}
