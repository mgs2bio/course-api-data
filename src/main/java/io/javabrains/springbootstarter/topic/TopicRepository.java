package io.javabrains.springbootstarter.topic;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;



public interface TopicRepository extends CrudRepository<Topic, String>{  //the second variable  is the primary key type
	
	//https://spring.io/blog/2014/05/21/what-s-new-in-spring-data-dijkstra#asynchronous-repository-method-invocations
	@Async
	public Future<List<Topic>> findByName(String name);

}
