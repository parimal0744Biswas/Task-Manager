package com.task.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.enums.TaskStatus;
import com.task.exception.SprintException;
import com.task.exception.TaskException;
import com.task.exception.UserException;
import com.task.model.Sprint;
import com.task.model.Task;
import com.task.model.User;
import com.task.repository.SprintRepo;
import com.task.repository.TaskRepo;
import com.task.repository.UserRepo;

@Service
public class TaskServiceImpl implements TaskService
{

	@Autowired
	private TaskRepo tRepo;

	@Autowired
	private SprintRepo sRepo;

	@Autowired
	private UserRepo uRepo;

	@Override
	public Task createTask(Long sprintId, Long userId, Task task) throws SprintException, UserException
	{
		Sprint sprint = sRepo.findById(sprintId).orElseThrow(() -> new SprintException("sprint not found"));

		sprint.getTasks().add(task);

		task.setSprint(sprint);

		List<User> userslist = uRepo.findAll().stream().filter(s -> s.getId() == userId).collect(Collectors.toList());

		if (userslist.isEmpty())
		{
			throw new UserException("User Not FOund");
		}
		task.setAssignee_user(userslist.get(0));

		return tRepo.save(task);
	}

	@Override
	public Task changeTaskAssignee(Long taskId, Long userid) throws UserException, TaskException
	{

		Task task = tRepo.findById(taskId).orElseThrow(() -> new TaskException("sprint not found"));

		List<User> userslist = uRepo.findAll().stream().filter(s -> s.getId() == userid).collect(Collectors.toList());

		if (userslist.isEmpty())
		{
			throw new UserException("User Not FOund");
		}
		task.setAssignee_user(userslist.get(0));

		return tRepo.save(task);
	}

	@Override
	public Task changeTaskStatus(Long taskId, TaskStatus status) throws TaskException
	{
		Task task = tRepo.findById(taskId).orElseThrow(() -> new TaskException("sprint not found"));
		task.setStatus(status);

		return tRepo.save(task);
	}

}
