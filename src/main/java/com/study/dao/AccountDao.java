package com.study.dao;

import com.study.entertity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Account> getAllAccount() {
        String sql = "select * from account";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
    }

    public void addMoney(String name, double money) {
        String sql = "update account set money=money+" + money + " where name='" + name + "'";
        jdbcTemplate.execute(sql);

    }

    public void descMoney(String name, double money) {
        String sql = "update account set money=money-" + money + " where name='" + name + "'";
        jdbcTemplate.execute(sql);
    }
}
