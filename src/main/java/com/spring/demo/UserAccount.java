package com.spring.demo;

/**
 * Created by tanuj on 7/10/17.
 */
public class UserAccount {

    private String name;
    private Integer Balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return Balance;
    }

    public void setBalance(Integer balance) {
        Balance = balance;
    }
    @Override
    public String toString() {
        return "UserAccount{" +
                "name='" + name + '\'' +
                ", Balance=" + Balance +
                '}';
    }

}