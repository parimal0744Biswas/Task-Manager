package com.task.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.task.exception.UserException;
import com.task.model.Task;
import com.task.model.User;

@Service
public interface UserService
{
	User createUser(User user);

	List<Task> getAllTaskByUser(Long userId) throws UserException;

}
