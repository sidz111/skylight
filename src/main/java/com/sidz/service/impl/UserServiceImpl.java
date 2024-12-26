package com.sidz.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	@Override
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isEmpty()) {
			return null;
		}
		else {
			return user.get();
		}
	}

	@Override
	public List<User> getUsersByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public String deleteUserById(Integer id) {
		userRepository.deleteById(id);
		return "User delete with id: "+id;
	}

	@Override
	public ResponseEntity<User> updateUser(User user) {
		Optional<User> u = userRepository.findById(user.getId());
		if(u.isEmpty()) {
			return ResponseEntity.badRequest().body(user);
		}
		else {
			 userRepository.save(user);
			 return ResponseEntity.ok(user);
		}
	}
}
