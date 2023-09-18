package com.aop.aopdemo.dao;

public interface AccountDAO {
    void addAccount();

    boolean doWork();

    public String getName();
    public void setName(String name);

    public String getServiceCode();
    public void setServiceCode(String serviceCode);

}
