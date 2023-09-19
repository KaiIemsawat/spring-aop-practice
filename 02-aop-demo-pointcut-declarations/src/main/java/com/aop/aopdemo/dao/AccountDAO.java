package com.aop.aopdemo.dao;

import com.aop.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccounts();

    void addAccount();
    boolean doWork();

    public String getName();
    public void setName(String name);

    public String getServiceCode();
    public void setServiceCode(String serviceCode);

}
