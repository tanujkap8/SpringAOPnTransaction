package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

/**
 * Created by ankur on 9/7/17.
 */
public class UserAccountService {

    @Autowired
    DataSource dataSource;

    public DataSource getDataSource() { return dataSource; }

    public void setDataSource(DataSource dataSource) { this.dataSource = dataSource; }

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserAccountService2 userAccountService2;

    public UserAccountService2 getUserAccountService2() { return userAccountService2; }

    public void setUserAccountService2(UserAccountService2 userAccountService2) { this.userAccountService2 = userAccountService2; }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) { this.transactionManager = transactionManager; }

    @Autowired
    private PlatformTransactionManager transactionManager;


    @Transactional
    public void insertUser(UserAccount userAccount) throws InterruptedException {

        String sql = "INSERT INTO UserAccount (name,balance)VALUES(?,?)";
        jdbcTemplate.update(sql, new Object[]{userAccount.getName(),userAccount.getBalance()});
    }

    //Spring Transaction Question 3
    public void updateUserUsingProgrammaticTransaction(UserAccount userAccount,UserAccount userAccount2, int balance) throws InterruptedException{

        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        String sql = "Update UserAccount set balance = ? where  name = ?";
        jdbcTemplate.update(sql, new Object[]{userAccount.getBalance()-balance,userAccount.getName()});
        updateUserUsingProgrammaticTransaction2(userAccount2,balance,status);
    }

    public void updateUserUsingProgrammaticTransaction2(UserAccount userAccount, int balance,TransactionStatus status) throws InterruptedException{

        String sql = "Update UserAccount set balance = ? where  name = ?";
        jdbcTemplate.update(sql, new Object[]{userAccount.getBalance()+balance,userAccount.getName()});
        transactionManager.commit(status);
    }

    //Spring Transaction Question 5
    @Transactional(readOnly = true)
    public void readUser() throws InterruptedException {
        String sql = "SELECT * FROM UserAccount WHERE name = ?";
        System.out.println(jdbcTemplate.queryForMap(sql, new Object[]{"Ankur"}));

    }

    @Transactional(readOnly = true)
    public void readAllUser() throws InterruptedException {
        String sql = "SELECT * FROM UserAccount";
        System.out.println(jdbcTemplate.queryForList(sql));

    }

    @Transactional(readOnly = true)
    public void readTransactions() throws InterruptedException {
        String sql = "SELECT * FROM AccountTransaction";
        System.out.println(jdbcTemplate.queryForList(sql));

    }

// Spring Transaction Question 4
    @Transactional
    public void updateUser(UserAccount sender, UserAccount reciever, int balance) throws InterruptedException {

        try {
            String sql = "Update UserAccount set balance = ? where  name = ?";
            jdbcTemplate.update(sql, new Object[]{sender.getBalance()-balance, sender.getName()});
            updateUser2(reciever,balance);
            userAccountService2.updateAccountTransaction(sender, reciever, balance);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser2(UserAccount userAccount, int balance) throws InterruptedException {
        String sql = "Update UserAccount set balance = ? where  name = ?";
        jdbcTemplate.update(sql, new Object[]{userAccount.getBalance()+balance,userAccount.getName()});
    }

    public void deleteUser(UserAccount userAccount) throws InterruptedException {
        String sql = "DELETE FROM UserAccount WHERE name = ?";
        jdbcTemplate.update(sql, new Object[]{userAccount.getName()});
    }
}