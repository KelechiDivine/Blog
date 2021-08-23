package com.demonblog.service;

import com.demonblog.exceptions.General_PostException;
import com.demonblog.model.Post;
import com.demonblog.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j

public class PostService {
	
	private final PostRepository postRepository;
	private final Post post;
	
	
	@GetMapping
	public List<Post> getAllPost(){
		return postRepository.findAll();
	}
	
	public void createPost(Post post){
		postRepository.save(post);
	}
	
	public void deletePost(Integer postId){
		
		boolean post1 = postRepository.existsById(postId);
		
		if (post1 == post.deletePost()){
			log.info("Post have been deleted from the database.");
		}
	}
	
	public void updatePost(String postTextField, Integer postId ) throws General_PostException {
		
		Post postInDatabase = postRepository.findById(postId).orElseThrow();
		
		if (postInDatabase != null && !Objects.equals(postInDatabase.getId(), postId)){
			postInDatabase.setPostTextField(postTextField);
			postRepository.save(postInDatabase);
		}
		
		if (postTextField.isEmpty()){
			throw new General_PostException("Post field is required...");
		}
	}
}
