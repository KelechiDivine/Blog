package com.demonblog.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Comments {
	
	@Id
	@GeneratedValue
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;
	
	@Column(nullable = false, length = 150)
	private String commentatorName;
	
	@CreationTimestamp
	private LocalDate dataCreated;
	
	@Column(nullable = false)
	private String content;
}
