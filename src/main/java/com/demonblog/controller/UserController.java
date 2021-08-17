package com.demonblog.controller;

import com.demonblog.exception.GeneralException;
import com.demonblog.exception.IdAlreadyExistException;
import com.demonblog.exception.UserNameAlreadyExistException;
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
		return userService.getUser();
		
	}
	
	@PostMapping("/postUser")
	public void registerUser(@RequestBody User user) throws IdAlreadyExistException {
		userService.addNewUser(user);
	}
	
	@DeleteMapping(path = "/deleteUser{userId}")
	public void deleteUser(@PathVariable("userId") Integer userId) throws IdAlreadyExistException {
		userService.deleteUser(userId);
	}
	
	@PutMapping(path = "/putUser")
	public void updateStudent(
			
			@PathVariable("userId") String username,
			@RequestParam(required = false) String email,
//			@RequestParam(required = false) String comments,
			@RequestParam(required = false) Integer id) throws GeneralException, UserNameAlreadyExistException {
		
		userService.updateUser(username, email, id);
	}
}
