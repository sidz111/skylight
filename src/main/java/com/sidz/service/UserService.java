package com.sidz.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sidz.entities.User;

public interface UserService {
	
	//CRUD  
	
	User addUser(User user);    // C- Create / add / insert
	
	List<User> getAllUsers();   // R - get all users
	
	User getUserById(Integer id);  // R - get user by id
	
	List<User> getUsersByName(String name); // R - get users by name
	
	String deleteUserById(Integer id);    // D - Delete
	
	ResponseEntity<User> updateUser(User user);      // U - Update user
}
