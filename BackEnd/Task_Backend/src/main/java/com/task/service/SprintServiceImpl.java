package com.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.exception.SprintException;
import com.task.model.Sprint;
import com.task.model.Task;
import com.task.repository.SprintRepo;

@Service
public class SprintServiceImpl implements SprintService
{
	@Autowired
	private SprintRepo sRepo;

	@Override
	public Sprint createSprint(Sprint sprint)
	{
		return sRepo.save(sprint);
	}

	@Override
	public List<Task> getTasksInSprint(Long sprintId) throws SprintException
	{
		return sRepo.findById(sprintId).orElseThrow(() -> new SprintException("Sprint not found")).getTasks();
	}

}
