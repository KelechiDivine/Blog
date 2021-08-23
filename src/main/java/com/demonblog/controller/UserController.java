package com.demonblog.controller;


import com.demonblog.exceptions.General_IdAlreadyExists;
import com.demonblog.exceptions.General_UserAlreadyExists;
import com.demonblog.model.User;
import com.demonblog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(path = "/userControllers")
@AllArgsConstructor


@RestController
public class UserController {

	@Autowired
	private final UserService userService;

		@GetMapping("/getUser")
		public List<User> getAllUsers() {
		return userService.getAllUser();
		}

	@PostMapping("/postUser")
	public void registerUser(@RequestBody User user) throws General_UserAlreadyExists {
		userService.createUser(user);
	}

	@DeleteMapping(path = "/deleteUser{username}")
	public void deleteUser(@PathVariable("username") String username) throws General_UserAlreadyExists {
		userService.deleteUser(username);
	}
	

	@PutMapping(path = "/putUser")
	public void updateUser(

			@PathVariable("username") String usernameField,
			@RequestParam(required = false) Integer userId,
//			@RequestParam(required = false) String comments,
			@RequestParam(required = false) String userEmail) throws General_IdAlreadyExists {

		userService.updateUser(usernameField, userId, userEmail);
	}
}
