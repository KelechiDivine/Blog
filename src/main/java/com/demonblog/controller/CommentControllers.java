//package com.demonblog.controller;
//
//import com.demonblog.exception.CommentException;
//import com.demonblog.exception.GeneralException;
//import com.demonblog.exception.IdAlreadyExistException;
//import com.demonblog.exception.UserNameAlreadyExistException;
//import com.demonblog.model.Comments;
//import com.demonblog.service.CommentService;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path = "/userComment")
//@AllArgsConstructor
//
//public class CommentControllers {
//
//	private final CommentService commentService;
//
//	@GetMapping("/getAllComments")
//	public List<Comments> getComments(){
//		return commentService.getAllUserComment();
//	}
//
//	@PostMapping("/postMapping")
//	public void postComment(@RequestBody Comments comments){
//		commentService.aNewComment(comments);
//	}
//
//
//	@DeleteMapping(path = "/deleteComment{commentId}")
//	public void deleteComment(@PathVariable("commentId") Integer commentId) throws CommentException {
//		commentService.deleteComment(commentId);
//	}
//
//
//	@PutMapping(path = "/putComment")
//	public void updateComment(
//
//			@PathVariable("commentId") String content,
////			@RequestParam(required = false) String email,
//			@RequestParam(required = false) Integer id) throws CommentException {
//
//		commentService.updateComment(content, id);
//	}
//
//}
