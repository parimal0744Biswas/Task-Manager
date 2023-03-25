package com.task.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.task.exception.SprintException;
import com.task.model.Sprint;
import com.task.model.Task;

@Service
public interface SprintService
{
	public Sprint createSprint(Sprint sprint);

	public List<Task> getTasksInSprint(Long sprintId) throws SprintException;
}
