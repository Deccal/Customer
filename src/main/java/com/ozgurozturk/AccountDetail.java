package com.ozgurozturk;

import javax.persistence.*;

/**
 * Created by Ozgur on 7.06.2017.
 */

@Entity
public class AccountDetail {


    @Id
    @GeneratedValue
    private long id;

    private String accountName;
    private double balance;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @ManyToOne
    private Customer customer;


    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "AccountDetail{" +
                "id=" + id +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                ", accountType=" + accountType +
                '}';
    }
}
