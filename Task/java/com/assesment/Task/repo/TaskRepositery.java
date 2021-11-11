package com.assesment.Task.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.assesment.Task.Utility.Tasks;

public interface TaskRepositery extends MongoRepository<Tasks, Integer> {

	
}
