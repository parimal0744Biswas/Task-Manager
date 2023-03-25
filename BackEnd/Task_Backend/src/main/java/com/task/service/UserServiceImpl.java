package com.task.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.exception.UserException;
import com.task.model.Task;
import com.task.model.User;
import com.task.repository.TaskRepo;
import com.task.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserRepo uRepo;

	@Autowired
	private TaskRepo tRepo;

	@Override
	public User createUser(User user)
	{
		return uRepo.save(user);
	}

	@Override
	public List<Task> getAllTaskByUser(Long userId) throws UserException
	{
//		User user = uRepo.findById(userId).orElseThrow(() -> new UserException("User not found"));
//
//		List<Task> tasks = user.getTask();
//
//		System.out.println(tasks);

		List<Task> tasks = tRepo.findAll();

		List<Task> fiteredTasks = tasks.stream().filter(s -> s.getAssignee_user().getId() == userId)
				.collect(Collectors.toList());

		return fiteredTasks;

	}

}
