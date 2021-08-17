package com.demonblog.repository;

import com.demonblog.model.Comments;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@Slf4j

public class CommentRepositoryTest {
	
	@BeforeEach
	public void setComments(){
		comments = new Comments();
	}
	
	@Autowired
	CommentRepository commentRepository;
	
	Comments comments;
	
	@Test
	public void testThatWeCanCreateAComment(){
		Comments createANewComment = new Comments();
		createANewComment.setCommentatorName("Kelechi Divine");
		createANewComment.setContent("I had a dream that Nigeria will be good again");
		createANewComment.setDataCreated(LocalDate.now());
		createANewComment.setId(1);
		
		Assertions.assertThat(createANewComment).isNotNull();
		
		log.info("Posted comment successfully -> {}", createANewComment);
	}
}