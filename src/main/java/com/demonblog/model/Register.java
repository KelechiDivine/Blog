package com.demonblog.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Register {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false, unique = true)
	private String password;
	
	@Column(unique = true)
	@NotNull
	private String mobile;
	
	@Column(nullable = false)
	private String countryName;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = true)
	private int countryCode;
	
	
}
