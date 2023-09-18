package com.aop.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class WildcardDaoImpl implements WildcardDAO{

    @Override
    public void addWithWildcard() {
        System.out.println(getClass() + " : DOING DB WORK : ADDING A MEMBERSHIP ACCOUNT\n");
    }
}
