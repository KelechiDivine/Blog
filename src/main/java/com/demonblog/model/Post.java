package com.demonblog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false, length = 500)
	private String postTextField;
	
	@Column(nullable = false)
	private LocalDateTime isCreated;
	
	@JoinColumn(nullable = false)
	@OneToOne
	private User user;
	
	@Column(nullable = false)
	@OneToMany
	private List<Comment> comments;
	
	@JoinColumn(nullable = false)
	@OneToOne
	private Title title;
	
	public boolean deletePost(){
		return true;
	}
}
