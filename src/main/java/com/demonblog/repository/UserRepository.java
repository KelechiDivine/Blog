package com.demonblog.repository;

import com.demonblog.model.Comments;
import com.demonblog.model.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {
	User findUserByFirstnameAndLastname(String firstname, String lastname);
	User findUserByFirstname(String userFirstName);
	User findUserByLastname(String userLastName);
	User findUserByComments(List<Comments> comments);
	
	Optional<User> findUserByUsername(String username);
	
	@Query("SELECT email FROM User WHERE email= ?1")
	Optional<User> findUserByEmail(@NonNull String email);
	
}
