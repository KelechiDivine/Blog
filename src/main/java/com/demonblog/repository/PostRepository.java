package com.demonblog.repository;

import com.demonblog.model.Post;
import com.demonblog.model.Title;
import com.demonblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository

public interface PostRepository extends JpaRepository<Post, Integer> {
	
	Post findPostByIsCreated(LocalDateTime isCreated);
	Post findPostByUser(User userPost);
	
	Optional<Post> findPostByTitle(Title postTitle);
	
	
}
