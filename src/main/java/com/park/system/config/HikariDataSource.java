package com.park.system.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceProvider {
    private static HikariDataSource dataSource;

    public static HikariDataSource getDataSource() {
        return dataSource;
    }
}