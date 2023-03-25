package com.task.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String username;

	private String password;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Task> task = new ArrayList<>();

}
