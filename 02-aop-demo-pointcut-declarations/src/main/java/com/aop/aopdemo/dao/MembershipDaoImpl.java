package com.aop.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDAO{

    @Override
    public void addAccount() {
        System.out.println(getClass() + " : DOING DB WORK : ADDING A MEMBERSHIP ACCOUNT\n");

    }

}
