package com.study.spring;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class JdbcDemo1 {
    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/spring");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        JdbcTemplate template=new JdbcTemplate(dataSource);
        template.execute("insert into account values (4,'ddd',1000)");

    }
}
