package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface CourseRepository extends CrudRepository<Course, String>{  //the second variable  is the primary key type
	
	List<Course> findByTopicId(String topicId);
	
	public List<Course> findByName(String name);

}
