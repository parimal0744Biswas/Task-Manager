package com.task.model;

import com.task.enums.TaskStatus;
import com.task.enums.TaskType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;
	private String description;

	@Enumerated(value = EnumType.STRING)
	private TaskType type;

	private TaskStatus status;

	@ManyToOne(cascade = CascadeType.ALL)
	private User assignee_user;

//	private LocalDateTime createdAt;
//
//	private LocalDateTime updatedAt;

	@ManyToOne(cascade = CascadeType.ALL)
	private Sprint sprint;

}
