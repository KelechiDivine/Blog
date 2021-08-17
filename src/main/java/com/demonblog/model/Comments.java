package com.demonblog.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Comments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false, length = 150)
	private String commentatorName;
	
	@CreationTimestamp
	private LocalDate dataCreated;
	
	@Column(nullable = false)
	private String content;
}
