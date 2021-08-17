package com.demonblog.service;

import com.demonblog.exception.CommentException;
import com.demonblog.model.Comments;
import com.demonblog.repository.CommentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service

public class CommentService {
	private final CommentRepository commentRepository;
	
	@GetMapping
	// get all user comment
	public List<Comments> getAllUserComment() {
		return commentRepository.findAll();
	}
	
	public void aNewComment(Comments comments) {
		commentRepository.save(comments);
	}
	
	public void deleteComment(Integer commentId) throws CommentException {
		boolean commentAlreadyExist = commentRepository.existsById(commentId);
		
		if (!commentAlreadyExist) {
			throw new CommentException("Comment has been deleted.");
		}
	}
	
	@Transactional
	
	public void updateComment(String content, Integer id) throws CommentException {
		Comments comments = commentRepository.findById(id).orElseThrow(CommentException::new);
		log.info("Comment doesn't exists.");
		
		if (content.isEmpty()) {
			log.info("Comment can't be null");
		}
		
		// update content in a comment
		
		if (comments != null && !Objects.equals(comments.getContent(), content)) {
			comments.setContent(content);
		}
		
		
		
	}
}
