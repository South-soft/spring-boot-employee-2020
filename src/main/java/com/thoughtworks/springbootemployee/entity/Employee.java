package com.thoughtworks.springbootemployee.entity;

public class Employee {

    private int id;
    private int companyId;
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
