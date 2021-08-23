package com.demonblog.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@CreationTimestamp
	private LocalDate commentIsCreated;
	
	@Column(nullable = false)
	private String commentTextField;
	
	@JoinColumn(nullable = false)
	@OneToOne
	private User commentUser;
	
	
	public boolean deleteComment(){
		return true;
	}
}
