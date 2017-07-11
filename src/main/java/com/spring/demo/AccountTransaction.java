package com.spring.demo;

/**
 * Created by tanuj on 7/11/17.
 */
public class AccountTransaction {
    //Spring Transaction Question 6
    private String sender;
    private String reciever;
    private Integer balanceTransfered;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public Integer getBalanceTransfered() {
        return balanceTransfered;
    }

    public void setBalanceTransfered(Integer balanceTransfered) {
        this.balanceTransfered = balanceTransfered;
    }
}
