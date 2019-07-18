package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//Service Components are the class file which contains @Service annotation. 
//These class files are used to write business logic in a different layer, separated from @RestController class file.
//@Service, @Controller, and @Repository are nothing but the specialized form of @Component annotation for certain situations.
//For example, DispatcherServlet will look for @RequestMapping on classes which are annotated using @Controller but not with @Component.



public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("java", "Core Java", "Core Java Description"),
			new Topic("javascript", "JavaScript", "JavaScript Description")
     ));
	
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topics = new ArrayList<>();
	    topicRepository.findAll().
	    forEach(topics::add);   
	  //Note that this forEach takes 'Consumer<? super Topic> action' (functional interface) as the input parameter.
	    // It tells that forEach needs to take a Lambda expression or method reference consuming Topic object as a argument and returning no result..
	    
       return topics;	    
	}
	@Transactional(readOnly=true)
	public Topic getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		Optional<Topic> topic = topicRepository.findById(id);   //Optional return type may or may not contain a non-null value object.
		if (topic.isPresent()) {
			return topic.get();
		}else {
			return null;
		}
		  
	}

	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public void updateTopic(String id, Topic topic) {
		/*for (int i = 0; i < topics.size(); i++ ) {
			if (id.equals(topics.get(i).getId())) {
				topics.set(i, topic);
			}
		}*/
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
