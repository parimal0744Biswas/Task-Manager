package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.exception.SprintException;
import com.task.model.Sprint;
import com.task.model.Task;
import com.task.service.SprintService;

@RestController
@RequestMapping("/sprints")
@CrossOrigin
public class SprintController
{

	@Autowired
	private SprintService sprintService;

	@PostMapping("/add")
	public ResponseEntity<Sprint> createSprint(@RequestBody Sprint sprint)
	{
		return new ResponseEntity<>(sprintService.createSprint(sprint), HttpStatus.CREATED);
	}

	@GetMapping("/all/{spid}")
	public ResponseEntity<List<Task>> getTasksInSprint(@PathVariable("spid") Long sprintId) throws SprintException
	{
		return new ResponseEntity<>(sprintService.getTasksInSprint(sprintId), HttpStatus.CREATED);
	}

}
