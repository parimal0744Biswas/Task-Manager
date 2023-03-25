package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.enums.TaskStatus;
import com.task.exception.SprintException;
import com.task.exception.TaskException;
import com.task.exception.UserException;
import com.task.model.Task;
import com.task.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController
{

	@Autowired
	private TaskService tService;

	@PostMapping("/add/{sid}")
	public ResponseEntity<Task> createTask(@PathVariable("sid") Long sprintId, @RequestParam("uid") Long userId,
			@RequestBody Task task) throws SprintException, UserException
	{
		return new ResponseEntity<>(tService.createTask(sprintId, userId, task), HttpStatus.CREATED);
	}

	@PatchMapping("/assign/{tid}")
	public ResponseEntity<Task> assignTaskToUser(@PathVariable("tid") Long taskid, @RequestParam("uid") Long userId)
			throws UserException, TaskException
	{
		return new ResponseEntity<>(tService.changeTaskAssignee(taskid, userId), HttpStatus.ACCEPTED);
	}

	@PatchMapping("/statuschange/{tid}")
	public ResponseEntity<Task> changeTaskStatus(@PathVariable("tid") Long taskid,
			@RequestParam("status") TaskStatus status) throws UserException, TaskException
	{
		return new ResponseEntity<>(tService.changeTaskStatus(taskid, status), HttpStatus.ACCEPTED);
	}

}
