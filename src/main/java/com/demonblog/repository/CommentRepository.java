package com.demonblog.repository;

import com.demonblog.model.Comment;
import com.demonblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	Comment findCommentsByCommentUser(User commentUser);
	Comment findCommentsById(Integer id);
	
	Optional<Comment> findCommentsByCommentIsCreatedBefore(LocalDate commentIsCreated);
	
}
