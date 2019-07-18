package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;
import io.javabrains.springbootstarter.topic.TopicNotFoundException;
import io.javabrains.springbootstarter.topic.TopicService;

@RestController
public class CourseController {
  
	@Autowired
	private CourseService courseService;

	
	@Autowired   //Spring injects topicService when TopicController is created. (@Autowired on Properties)
	private TopicService topicService;
	
	//read https://springframework.guru/spring-requestmapping-annotation/
	
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCoursess(@PathVariable String id){
		return courseService.getAllCourses(id);
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@PathVariable String topicId, @RequestBody Course course) {
		Topic topic = topicService.getTopic(topicId);
		if (topic == null) {
		  throw new TopicNotFoundException(topicId+" not found!");
		}
		
		course.setTopic(topic);
		courseService.addCourse(course);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
	
}
