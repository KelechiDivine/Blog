package com.demonblog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
//@Documented
@AllArgsConstructor
@NoArgsConstructor

public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private String username;
	
	
	@Column(nullable = false, length = 1000)
	private String text;
	
	
	@Column(nullable = false)
	private LocalDateTime localDateTime;
	
	
	@Column(nullable = true)
	private String comment;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Comments> comments;
	
	public void addComment(Comments... comment) {
		if (this.comments == null)
			this.comments = new ArrayList<>();
		this.comments.addAll(Arrays.asList(comment));
		
	}
	
	@JoinColumn(nullable = false)
	@ManyToOne
	private User user;
}
