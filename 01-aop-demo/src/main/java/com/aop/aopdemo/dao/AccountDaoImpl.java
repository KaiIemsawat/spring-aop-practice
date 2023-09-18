package com.aop.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDAO{

    @Override
    public void addAccount() {
        System.out.println(getClass() + " : DOING DB WORK : ADDING AN ACCOUNT\n");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " : DOING DB WORK : ADDING AN ACCOUNT : IN DO_WORK()\n");
        return false;
    }

}
