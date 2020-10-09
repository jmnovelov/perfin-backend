package com.perfin.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long accountId;

    private String name;

    private double amount;

    private AccountType type; 

    protected Account() {

    }

    public Account(String name, double amount, AccountType type) {
        this.name = name;
        this.amount = amount;
        this.type = type;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public AccountType getType() {
        return type;
    }
}
