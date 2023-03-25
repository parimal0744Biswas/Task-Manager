package com.task.service;

import org.springframework.stereotype.Service;

import com.task.enums.TaskStatus;
import com.task.exception.SprintException;
import com.task.exception.TaskException;
import com.task.exception.UserException;
import com.task.model.Task;

@Service
public interface TaskService
{

	public Task createTask(Long sprintId, Long userId, Task task) throws SprintException, UserException;

	public Task changeTaskAssignee(Long taskid, Long userid) throws UserException, TaskException;

	public Task changeTaskStatus(Long taskId, TaskStatus status) throws TaskException;

}
