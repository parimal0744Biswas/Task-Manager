package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.exception.UserException;
import com.task.model.Task;
import com.task.model.User;
import com.task.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://example.com", maxAge = 3600)
public class UserController
{

	@Autowired
	private UserService uService;

	@PostMapping("/add")
	public ResponseEntity<User> createSprint(@RequestBody User user) throws UserException
	{
		return new ResponseEntity<>(uService.createUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/all/task")
	public ResponseEntity<List<Task>> getAllTaskByUser(@RequestParam("uid") Long userid) throws UserException
	{
		return new ResponseEntity<>(uService.getAllTaskByUser(userid), HttpStatus.CREATED);
	}

}
