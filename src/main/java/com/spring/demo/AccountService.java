package com.spring.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tanuj on 7/10/17.
 */
public class AccountService
{
    private JdbcTemplate jdbcTemplate;

    private AccountService accountService;

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void insertUserAccount() throws InterruptedException {
        String sql = "INSERT INTO UserAccount (name,Balance)VALUES(?,?)";
        jdbcTemplate.update(sql, new Object[]{"TANUJ",130000});
     }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void readUserAccount() throws InterruptedException {
        String sql = "SELECT * FROM UserAccount WHERE Balance = ?";
        System.out.println(jdbcTemplate.queryForMap(sql, new Object[]{130000}));
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED,rollbackFor = RuntimeException.class)
    public void updateUserAccount() throws InterruptedException{
        String sql = "UPDATE UserAccount SET Balance = ? where name=?";
        jdbcTemplate.update(sql, new Object[]{20000,"TANUJ"});
    }
    public void deleteUserAccount() throws InterruptedException{
        String sql = "DELETE FROM UserAccount where name=?";
        jdbcTemplate.update(sql, new Object[]{"TANUJ"});
    }
    }

