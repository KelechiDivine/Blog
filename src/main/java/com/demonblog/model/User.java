package com.demonblog.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

//@Table(name = "User")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private String lastname;
	
	@Column(nullable = false)
	private String firstname;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String mobile;
	
	@Column(nullable = false, length = 250)
	private String about;
	
	@Column(nullable = false)
	private String countryName;
	
	@Column(nullable = false, unique = true)
	@NotNull
	private String username;
	
	@NotNull
	@OneToMany
	private List<Comments> comments;
	
	
}
