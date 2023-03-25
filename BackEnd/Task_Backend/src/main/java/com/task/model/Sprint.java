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
public class Sprint
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

//	private String startDate;
//
//	private String endDate;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sprint")
	private List<Task> tasks = new ArrayList<>();

}
