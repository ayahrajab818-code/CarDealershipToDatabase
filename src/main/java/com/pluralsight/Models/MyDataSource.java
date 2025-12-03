package com.pluralsight.Models;

import org.apache.commons.dbcp2.BasicDataSource;

public class MyDataSource {
    private static BasicDataSource ds = new BasicDataSource();


    static {
        ds.setUrl("jdbc:mysql://localhost:3306/dealership_db");
        ds.setUsername("root");
        ds.setPassword("Yearup");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(50);
    }


    public static BasicDataSource getDataSource() {
        return ds;
    }

}
