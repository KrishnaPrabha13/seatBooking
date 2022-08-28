/**
 * 
 */
package com.srm.core.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.srm.core.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
	Optional<User> findByName(String username);
	
	Boolean existsByName(String username);

	Boolean existsByEmail(String email);

}