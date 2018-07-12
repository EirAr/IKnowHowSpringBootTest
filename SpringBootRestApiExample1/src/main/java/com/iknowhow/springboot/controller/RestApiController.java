package com.iknowhow.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.iknowhow.springboot.model.User;
import com.iknowhow.springboot.service.UserService;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	UserService userService; //Service which will do all data retrieval/manipulation work
	 
	// -------------------Retrieve All Users---------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		//TODO
		List<User> allUsers = userService.findAllUsers();
		if(allUsers.isEmpty()) {
			System.out.println("User List is Empty.");
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
	}

	// -------------------Retrieve Single User------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") long id) {
		//TODO
		User user = userService.findById(id);
		
		 if (user == null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }
		 
		 return new ResponseEntity<>(user, HttpStatus.FOUND);
	}

	// -------------------Create a User-------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		//TODO
		if(userService.isUserExist(user)) {
			System.out.println("User already exists.");
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		userService.saveUser(user);
		
		if(!userService.isUserExist(user)) {
			System.out.println("User was not saved. Please try again.");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// ------------------- Update a User ------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		//TODO
		userService.findById(id);
	
		userService.updateUser(user);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// ------------------- Delete a User-----------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
		//TODO
		userService.findById(id);
		
		userService.deleteUserById(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// ------------------- Delete All Users-----------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteAllUsers() {
		//TODO
		userService.deleteAllUsers();
		
		List<User> allUsers = userService.findAllUsers();
		if(!allUsers.isEmpty()) {
			System.out.println("Users were not deleted. Please try again.");
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
		
			return new ResponseEntity<User>(HttpStatus.OK);
		}
	}

}