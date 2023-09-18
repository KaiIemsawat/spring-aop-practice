package com.aop.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDAO{

    private String name;
    private String serviceCode;


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
