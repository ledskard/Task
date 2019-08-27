package com.exercise.task.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.task.Models.Task;
import com.exercise.task.Services.TaskService;

@RestController
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@GetMapping("/task/{id}")
	public ResponseEntity<Task> searchById(@PathVariable("id")Long id){
		Task searchTaskById = taskService.searchById(id);
		return ResponseEntity.ok(searchTaskById);
	}
	
	@GetMapping("/task/{tasknome}")
	public ResponseEntity<Task> searchTaskByTaskNome(@PathVariable("tasknome") String taskNome){
		Task searchTaskByTaskNome = taskService.searchByTask(taskNome);
		return ResponseEntity.ok(searchTaskByTaskNome);
	}
	
	@GetMapping("/task")
	public ResponseEntity<List<Task>> searchAll(){
		List<Task> taskSearchAll = taskService.searchAll();
		return ResponseEntity.ok(taskSearchAll);
	}
	@PostMapping("/task")
	public ResponseEntity<Task> addTask(@RequestBody Task newTask){
		Task adicionaTask = taskService.addTask(newTask);
		return ResponseEntity.ok(adicionaTask);
	}
	@PutMapping("/task/{tasknome}")
	public ResponseEntity<Task> updateTaskByTaskNome(@RequestBody Task newTask, @PathVariable("taskNome") String task){
		Task taskAtt = taskService.updateTask(task, newTask);
		return ResponseEntity.ok(taskAtt);
	}
	@DeleteMapping("/task/{id}")
	public ResponseEntity<?> deleteTaskById(@PathVariable("id") Long id){
		taskService.deleteTask(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("body");
	}
	
}



