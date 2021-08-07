package com.demonblog.service;

import com.demonblog.exception.GeneralException;
import com.demonblog.exception.IdAlreadyExistException;
import com.demonblog.exception.UserNameAlreadyExistException;
import com.demonblog.model.User;
import com.demonblog.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j


public class UserService {
	private final UserRepository userRepository;
	
	@GetMapping
	public List<User> getUser(){
		return userRepository.findAll();
	}
	
	//creating a new user
	public void addNewUser(User user) throws IdAlreadyExistException {
		Optional<User> userOptional = userRepository.findById(user.getId());
		
		if (userOptional.isPresent()){
			throw new IdAlreadyExistException("User with id " + user.getId() + "already exist");
		}
		userRepository.save(user);
	}
	
	//deleting a user
	
	public void deleteUser(Integer userId) throws IdAlreadyExistException {
		boolean userIdExist = userRepository.existsById(userId);
		
		if (!userIdExist){
			throw new IdAlreadyExistException("user with this id doesn't exist.",
					new IllegalStateException());
		}
		userRepository.deleteById(userId);
	}
	
	@Transactional
	public void updateUser(String username, String email, Integer id) throws GeneralException, UserNameAlreadyExistException {
		
		User user = userRepository.findById(id).orElseThrow(GeneralException::new);
		log.info("A user with these id " + user.getId() + " doesn't exists.");
		
		if (username != null && username.length() > 0 && !Objects.equals(user.getUsername(), username)){
			user.setUsername(username);
		}
		
		if (email != null && !Objects.equals(user.getEmail(), email)){
			
			//Check if email field is null
			
			if (email.isEmpty()){
				log.info("Please provide an email");
			}
			
			//Check if email doesn't contains "@gmail.com"
			if (!email.contains("@gmail.com")){
				log.info("Invalid email");
			}
		}
		
		if (username != null && !Objects.equals(user.getUsername(), username)){
			Optional<User> userOptional = userRepository
					.findUserByUsername(username);
			if (userOptional.isPresent()){
				throw new UserNameAlreadyExistException("User with email "+
						user.getUsername() + "already exist");
			}
			
			user.setUsername(username);
		}
	}
	
}

