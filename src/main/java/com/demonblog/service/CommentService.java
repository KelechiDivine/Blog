package com.demonblog.service;

import com.demonblog.exceptions.General_CommentException;
import com.demonblog.model.Comment;
import com.demonblog.repository.CommentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Slf4j
@Service

@Transactional



public class CommentService {
	
	private final CommentRepository commentRepository;
	private final Comment comment;
	
	@GetMapping
	public List<Comment> getAllComment() {
		return commentRepository.findAll();
	}
	
	public void createComment(Comment newComment) {
		commentRepository.save(newComment);
	}
	
	public void deleteComment(Integer commentId){
	
		boolean comment1 = commentRepository.existsById(commentId);
		
		if (comment1 == comment.deleteComment()){
			log.info("Comment deleted successfully...");
		}
	}
	
	public void updateComment(String commentText, Integer contextId) throws General_CommentException {
		
		Comment commentExistInRepo = commentRepository.findById(contextId).orElseThrow();
		
		if (commentExistInRepo != null && !Objects.equals(commentExistInRepo.
				getCommentTextField(), commentText)){
			commentExistInRepo.setCommentTextField(commentText);
			commentRepository.save(commentExistInRepo);
		}
		
		if (commentText.isEmpty()){
			throw new General_CommentException("Comment field can't be empty.");
		}
	}
}