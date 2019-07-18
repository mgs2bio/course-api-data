package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	

	
	public List<Course> getAllCourses(String topicId){
		//return topics;
		List<Course> courses = new ArrayList<>();
	    courseRepository.findByTopicId(topicId).
	    forEach(courses::add);
	    //Note that this forEach takes 'Consumer<? super Topic> action' (functional interface) as the input parameter.
	    // It tells that forEach needs to take a Lambda expression or method reference ("::") consuming Topic object as a argument and returning no result.
	    
       return courses;	    
	}
	
	public Course getCourse(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		Optional<Course> course = courseRepository.findById(id);   //Optional return type may or may not contain a non-null value object.
		if (course.isPresent()) {
			return course.get();
		}else {
			return null;
		}
		  
	}

	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void updateCourse(Course course) {
		/*for (int i = 0; i < topics.size(); i++ ) {
			if (id.equals(topics.get(i).getId())) {
				topics.set(i, topic);
			}
		}*/
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
}
