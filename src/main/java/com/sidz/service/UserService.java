package com.sidz.service;

import java.util.List;

import com.sidz.entities.User;

public interface UserService {
	
	//CRUD  
	
	User addUser(User user);    // C- Create / add / insert
	
	List<User> getAllUsers();
}
