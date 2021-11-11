package com.assesment.Task.service;

import java.util.List;
import java.util.Optional;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Add;
import org.springframework.data.mongodb.core.messaging.Task;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assesment.Task.Utility.SequenceNum;
import com.assesment.Task.Utility.Tasks;
import com.assesment.Task.repo.TaskRepositery;


@Service
public class TaskService {
	
	@Autowired
	private MongoOperations mongoOperations;
	
	@Autowired
	TaskService ts;
	
	@Autowired //injecting task repository
	private TaskRepositery tr;
	
	public int generateSequence(int seq) {

		   SequenceNum counter = mongoOperations.findAndModify(           
				   query(where("_id").is(seq)),        
				   new Update().inc("squenumber",1),        
				   options().returnNew(true).upsert(true),
	                SequenceNum.class);
	            return counter.getSquenumber();

	    }
	 
	
	public Tasks saveall(Tasks tasks) {	
		tasks.setId(ts.generateSequence(Tasks.SEQUENCE_NAME));
		tasks.setIsDone(false);
		tr.save(tasks);
		return tasks;
	}
	
	public List<Tasks> getall() {
		List<Tasks> tasks=tr.findAll();
		return tasks;
	}

   
	public Tasks update(Integer id)
	{
		Optional<Tasks> optional=tr.findById(id);
		Tasks tasks=optional.get();
		
		if(tasks != null) {
			tasks.setIsDone(!tasks.getIsDone());
			tr.save(tasks);
			return tasks;
		}
		return null;
	}

	public int deletebyid(Integer id) {
		tr.deleteById(id);
		return id;
	}
	
	

	
}

