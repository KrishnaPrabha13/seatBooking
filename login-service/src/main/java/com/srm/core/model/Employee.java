package com.srm.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="employee")
public class Employee {

    @Id
	private int id;
	private String userid;
	private String username;
	private String userdept;
	private String manager;
	private String email;
	private String phone;
	private String userstatus;
	private String password;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserdept() {
        return this.userdept;
    }

    public void setUserdept(String userdept) {
        this.userdept = userdept;
    }

    public String getManager() {
        return this.manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserstatus() {
        return this.userstatus;
    }

    public void setUserstatus(String userstatus) {
        this.userstatus = userstatus;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee(int id, String userid, String username, String userdept, String manager, String email, String phone, String userstatus, String password) {
        this.id = id;
        this.userid = userid;
        this.username = username;
        this.userdept = userdept;
        this.manager = manager;
        this.email = email;
        this.phone = phone;
        this.userstatus = userstatus;
        this.password = password;
    }

    
}
