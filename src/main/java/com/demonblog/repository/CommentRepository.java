package com.demonblog.repository;

import com.demonblog.model.Comments;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Integer> {
	
	Comments findCommentsByCommentatorName(String ownerOfComment);
	Comments findCommentsByContent(String commentContent);
	
	@Query("SELECT commentatorName FROM Comments WHERE commentatorName= ?1")
	Optional<Comments> findByCommentatorNameExists(@NotNull String commentatorNameExist);
}
