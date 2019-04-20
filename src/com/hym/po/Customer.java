package com.hym.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class Customer implements Serializable {
    private int id;
    private String username;
    private String jobs;
    private String phone;

    public Customer(int id,String jobs) {
        this.id=id;
        this.jobs=jobs;
    }

    public Customer(int id, String username, String jobs, String phone) {
        this.id = id;
        this.username = username;
        this.jobs = jobs;
        this.phone = phone;
    }
}
