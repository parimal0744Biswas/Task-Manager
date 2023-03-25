package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.model.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long>
{

}
