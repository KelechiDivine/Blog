package com.demonblog.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false, length = 50)
	private String lastname;
	
	@Column(nullable = false, length = 50)
	private String firstname;
	
	@Column(unique = true, nullable = false, length = 50)
	private String email;
	
	@Column(unique = true, nullable = false, length = 20)
	private String mobile;
	
	@Column(nullable = false, length = 250)
	private String about;
	
	@Column(nullable = false, length = 30)
	private String countryName;
	
	@Column(nullable = false, unique = true, length = 30)
	@NotNull
	private String username;
	
	@JoinColumn(nullable = false)
	@OneToOne
	private Post userPost;
	
	public boolean alreadyExits() {
		return false;
	}
}
