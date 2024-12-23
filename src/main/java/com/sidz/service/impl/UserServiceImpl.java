package com.sidz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidz.entities.User;
import com.sidz.repository.UserRepository;
import com.sidz.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User addUser(User user) {
//		User u = new User();
//		userRepository.save(u);
//		return u;
		return this.userRepository.save(user);
	}
	
}
