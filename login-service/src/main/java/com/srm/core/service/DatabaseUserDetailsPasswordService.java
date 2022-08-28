/**
 * 
 */
package com.srm.core.service;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srm.core.model.Role;
import com.srm.core.model.User;
import com.srm.core.repository.UserRepository;


@Transactional
@Service
public class DatabaseUserDetailsPasswordService implements UserDetailsPasswordService {

  private UserRepository userRepository;

  private  User user = new User();

  public DatabaseUserDetailsPasswordService(UserRepository userRepository, User user) {
    this.userRepository = userRepository;
    this.user = user;
    Set<Role> role_Set = new HashSet<Role>();
    
    // Adding elements to the Set
    // using add() method
    role_Set.add(new Role(1,"USER"));
    role_Set.addAll(role_Set);
    user.setRoles(role_Set);
  }

@Override
public UserDetails updatePassword(UserDetails user, String newPassword) {
	// TODO Auto-generated method stub
	return null;
}


}