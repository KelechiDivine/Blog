package com.demonblog.repository;

//import com.demonblog.model.Post;
import com.demonblog.model.User;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j

public class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	User user;
	
	@BeforeEach
	void setUser(){
		user = new User();
	}
	
	@Test
	public void testThatWeCanCreateUser(){
		User newUser = new User();
		newUser.setFirstname("Kelechi");
		newUser.setAbout("I am a software backend engineer");
		newUser.setEmail("okoroaforkelechi123@gmail");
		newUser.setLastname("Okoroafor");
		newUser.setMobile("08082167764");
		
//		User userSaved = userRepository.save(newUser);
		
		Assertions.assertThat(newUser).isNotNull();
		log.info("User created successfully -> {}", newUser);
	}

}