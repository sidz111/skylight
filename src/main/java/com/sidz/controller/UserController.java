package com.sidz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sidz.entities.User;
import com.sidz.service.UserService;

@RestController
//@RequestMapping("/user")  //common api for all rest api's
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		userService.addUser(user);
		return user;
	}
	
	@GetMapping("/allUsers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	
//Whole Class with all parameters    ---------  @RequestBody
// Only single-single parameters like when we wanna update something--  @RequestParam

}