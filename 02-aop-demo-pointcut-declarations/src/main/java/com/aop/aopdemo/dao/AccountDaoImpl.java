package com.aop.aopdemo.dao;

import com.aop.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDAO{

    private String name;
    private String serviceCode;


    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

//        simulate an exception
        if (tripWire) {
            throw new RuntimeException(" Trip Wire has set to " + tripWire + "..!");
        }

        List<Account> accounts = new ArrayList<>();

        Account acc1 = new Account("Titann", "999");
        Account acc2 = new Account("Zukk", "999");
        Account acc3 = new Account("Stokii", "997");

        accounts.add(acc1);
        accounts.add(acc2);
        accounts.add(acc3);

        return accounts;
    }

    @Override
    public void addAccount() {
        System.out.println(getClass() + " : DOING DB WORK : ADDING AN ACCOUNT\n");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " : DOING DB WORK : ADDING AN ACCOUNT : IN DO_WORK()\n");
        return false;
    }


    public String getName() {
        System.out.println(getClass() + " : IN GET_NAME()\n");
        return name;
    }
    public void setName(String name) {
        System.out.println(getClass() + " : IN SET_NAME()\n");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " : IN GET_SERVICE_CODE()\n");
        return serviceCode;
    }
    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " : IN SET_SERVICE_CODE()\n");
        this.serviceCode = serviceCode;
    }

}
