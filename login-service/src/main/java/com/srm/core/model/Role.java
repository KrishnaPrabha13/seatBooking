package com.srm.core.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "role")
public class Role {

    @Id
    private int roleId;

    @Field("user_role_name")
    private String role;

    public Role() {
    }

    public Role(int roleId,String roleName) {
    this.roleId=roleId;
    this.role=roleName;
    }
    
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
