package com.sware.demo.repositories;
import java.awt.List;
import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sware.demo.domains.User;
@Transactional
public interface UserRepository extends MongoRepository<User, String> {
	   public User findById(String departure);

	public ArrayList<User> findByEmail(String email);
	
	
}
