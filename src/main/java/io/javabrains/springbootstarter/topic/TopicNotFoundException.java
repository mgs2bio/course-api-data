package io.javabrains.springbootstarter.topic;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TopicNotFoundException extends RuntimeException {
    

	public TopicNotFoundException(String exception) {
	    super(exception);
	  }

}
