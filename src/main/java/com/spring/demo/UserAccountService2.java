package com.spring.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ankur on 10/7/17.
 */
public class UserAccountService2 {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Spring Transaction Question 6
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateAccountTransaction(UserAccount sender,UserAccount reciever,int balance){
        String sql = "INSERT INTO AccountTransaction (sender,reciever,balanceTransfered)VALUES(?,?,?)";
        jdbcTemplate.update(sql, new Object[]{sender.getName(),reciever.getName(),balance});
        throw new RuntimeException("exception is thrown");
    }
}