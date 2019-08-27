package com.exercise.task.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercise.task.Models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	public Optional<Task> findByTaskNome(String taskNome);
}
