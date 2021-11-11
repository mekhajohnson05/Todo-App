	package com.assesment.Task.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.messaging.Task;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.assesment.Task.Utility.Tasks;
import com.assesment.Task.repo.TaskRepositery;
import com.assesment.Task.service.TaskService;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {
	
	
	

	@Autowired
	private TaskService ts;
	
	@Autowired
	private TaskRepositery tr;
	
	@PostMapping("/tasks")
	public void saveTask(@RequestBody Tasks tasks) {
		ts.saveall(tasks);
	}
	
	@GetMapping("/tasks")
	public List<Tasks> getalltasks(){
		return ts.getall();
		}
	
	@PutMapping("/tasks/{id}")
	public ResponseEntity<Tasks> update(@PathVariable Integer id){
		return ResponseEntity.ok(ts.update(id));
		
	}  

	 @DeleteMapping("/tasks/{id}")
	public String deleteall(@PathVariable("id")Integer id) {
		 System.out.print(id);																			
		ts.deletebyid(id);
		return "success";
	}
	 
	
	 
}	