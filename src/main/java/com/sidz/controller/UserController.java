package com.sidz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sidz.entities.User;
import com.sidz.service.UserService;

@RestController // diff between rest API ans API
//@RequestMapping("/user")  //common api for all rest api's
public class UserController {

	// POST, GET, DELETE, PUT
	// @RequestBody ----> for passing object
	// @RequestParam ---> for passing only variables

	@Autowired
	UserService userService;

	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		userService.addUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@GetMapping("/allUsers")
	public ResponseEntity<?> getAllUsers() {
		List<User> list = userService.getAllUsers();
		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("There is no Users");
		}

		return ResponseEntity.status(HttpStatus.OK).body(list);

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") Integer id) {
		Optional<User> u = Optional.ofNullable(userService.getUserById(id));
		if (u.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not present with id: " + id);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(u);
		}
	}

	@GetMapping("/getByName/{name}")
	public List<User> getUserByName(@PathVariable("name") String name) {
		return userService.getUsersByName(name);
	}

	@GetMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body("User Deleted");
	}

	@PostMapping("update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

//Whole Class with all parameters    ---------  @RequestBody
// Only single-single parameters like when we wanna update something--  @RequestParam

}
