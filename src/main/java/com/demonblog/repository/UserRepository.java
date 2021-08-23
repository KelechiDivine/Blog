package com.demonblog.repository;

import com.demonblog.model.Post;
import com.demonblog.model.User;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.hibernate.loader.Loader.SELECT;

//
//import com.demonblog.model.Comments;
//import com.demonblog.model.User;
//import lombok.NonNull;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import java.util.List;
//import java.util.Optional;
//
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findUserByUsername(String username);
	User findUserByUserPost(Post userPost);
	
	@Query("SELECT userPost FROM User WHERE userPost = ?1")
	Optional<User> findUserByEmail(@NotNull String email);
	
	void deleteByUsername(String username);
}