package com.aop.aopdemo;

public class Account {

    private String name;
    private String level;

    /* CONSTRUCTORS */
    public Account() {}
    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }

    /* GETTERS / SETTERS */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }


    /* TO_STRING() */
    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
