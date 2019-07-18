package io.javabrains.springbootstarter.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.javabrains.springbootstarter.topic.Topic;

@Entity
@Table(name = "Courses")
public class Course {
	
	@Id 
	@Column(name = "course_id")
	private String id;
	@Column(name = "course_name_1")
	private String name;
	//@Column(name = "course_description")
	@Transient   //description column will not be added to the Courses table
	private String description;
	@ManyToOne
	private Topic topic;
	
	
	Course(){
		
	}
	Course (String id, String name, String description, String topicId){
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId, "", "");
	}
	
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
		   
	
}
