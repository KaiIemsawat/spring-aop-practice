package com.aop.aopdemo.dao;

import com.aop.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountParameterDaoImpl implements AccountParameterDAO{

    @Override
    public void addAccount(Account theAccount, boolean tf) {
        System.out.println(getClass() + " : DOING DB WORK : ADDING AN ACCOUNT THAT REQUIRES PARAMETER\n");

    }
}
