package com.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcDemo2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemple", JdbcTemplate.class);
        jdbcTemplate.execute("delete from  account where id=4");
    }
}
