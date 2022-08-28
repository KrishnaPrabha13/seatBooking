package com.srm.core.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "userlogin")
public class User implements Serializable {

	@Id
    private ObjectId id; 
    
	public ObjectId getId() {
		return id;
	}


	public void setObjectId(ObjectId id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




	@Field("emailid")
    private String email;
  
	@Field("userpwd")
    private String password;
    
	@Field("username")
    private String name;
	
	private Set<Role> roles;
	
	public Set<Role> getRoles() {
		Set<Role> role_Set = new HashSet<Role>();
		role_Set.add(new Role(1,"USER")); 
		roles=role_Set;
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	public User(User user) {
		this.email = user.email;
		this.password = user.password;
		this.name = user.name;
	}

	public User() {
    }

   
}
