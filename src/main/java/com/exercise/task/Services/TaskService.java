package com.exercise.task.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.task.Models.Task;
import com.exercise.task.Repository.TaskRepository;


@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository; 
	//get
	public Task searchById(Long id) {
		return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Funcionando"));
	}
	//get
	public List<Task> searchAll() {
		return taskRepository.findAll();
	}
	//get
	public Task searchByTask(String taskNome) {
		Optional<Task> buscaPorTask = taskRepository.findByTaskNome(taskNome);
		return buscaPorTask.get();	
	}
	//post
	public Task addTask(Task newTask) {
		return taskRepository.save(newTask);
	}
	//put 
	public Task updateTask(String taskNome, Task newTask) {
		Task savedTask = taskRepository.findByTaskNome(taskNome).get();		
		BeanUtils.copyProperties(newTask, savedTask, "id");
		return taskRepository.save(savedTask);
	}
	//delete
	public void deleteTask(Long id) {
		 taskRepository.deleteById(id);
	}
}