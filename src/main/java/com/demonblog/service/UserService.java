package com.demonblog.service;

import com.demonblog.exceptions.General_IdAlreadyExists;
import com.demonblog.exceptions.General_UserAlreadyExists;
import com.demonblog.model.User;
import com.demonblog.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@AllArgsConstructor
@Service
@Slf4j
@Transactional

public class UserService {
	
	private final UserRepository userRepository;
	
	@GetMapping
	
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	//create a new user
	
	public void createUser(User newUser) throws General_UserAlreadyExists {
		User userIsPresent = userRepository.findUserByUsername(newUser.getUsername());
		
		if (userIsPresent.alreadyExits()){
			throw new General_UserAlreadyExists("A user with name " + newUser.getUsername() + " already exists." );
		}
		else {
			userRepository.save(newUser);
		}
	}
	
	public void deleteUser(String username) throws General_UserAlreadyExists {
		
		if (!userNameExist()){
			throw new General_UserAlreadyExists("user with this name doesn't exist.");
		}
		else {
			userRepository.deleteByUsername(username);
		}
	}
	
	private boolean userNameExist() {
		return true;
	}
	
	public void updateUser(String usernameField, Integer userId, String userEmail)
			throws General_IdAlreadyExists {
		
		Optional<User> id = userRepository.findById(userId);
		Optional<User> email = userRepository.findUserByEmail(userEmail);
		User name = userRepository.findUserByUsername(usernameField);
		
		log.info("A user with name " + name.getUsername() + " doesn't exists.");
		
		if (usernameField.length() > 0 && !Objects.equals(name.getUsername(), usernameField)) {
			name.setUsername(usernameField);
			log.info("User name updated successfully.!!");
		}
		
		if (id.isPresent()){
			throw new General_IdAlreadyExists("A user with id " + userId + "already exist");
		}
		
		if (!userEmail.contains("@.com")){
			if (userEmail.length()<=0){
				log.info("This email " + userEmail + " is invalid");
			}
		}
		
		if (email.isPresent() && !Objects.equals(name.getEmail(), email)){
			name.setEmail(userEmail);
		}
	}
}
