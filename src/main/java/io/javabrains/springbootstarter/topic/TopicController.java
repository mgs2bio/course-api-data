package io.javabrains.springbootstarter.topic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.logging.CustomFilter;
import io.javabrains.util.BasicConfiguration;

@RestController
public class TopicController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TopicController.class);
	//read https://springframework.guru/spring-requestmapping-annotation/
	
	@Autowired   //Spring injects topicService when TopicController is created. (@Autowired on Properties)
	private TopicService topicService;
	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@Autowired
	private BasicConfiguration configuration;

	@RequestMapping("/dynamic-configuration")
	public Map dynamicConfiguration() {
	    // Not the best practice to use a map to store differnt types!
	    Map map = new HashMap();
	    map.put("message", configuration.getMessage());
	    map.put("number", configuration.getNumber());
	    map.put("key", configuration.isValue());
	    return map;
	}
	
	@RequestMapping("/welcome")
	public String getWelcomeMsg(){
		return welcomeMessage;
	}
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		LOGGER.info("getting topics");
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Resource<Topic> getTopic(@PathVariable String id) {
		Topic topic = topicService.getTopic(id);
		Resource<Topic> resource = new Resource<Topic>(topic);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllTopics());
		resource.add(linkTo.withRel("all-topics"));
		return resource;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		 topicService.addTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
		 topicService.updateTopic(id,topic);
	}
}
