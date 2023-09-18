package com.aop.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BooleanAccountDaoImpl implements BooleanAccountDAO {

    @Override
    public boolean addAccount() {
        System.out.println(getClass() + " : DOING DB WORK : ADDING AN ACCOUNT WITH RETURN TYPE BOOLEAN\n");
        return true;
    }

}
