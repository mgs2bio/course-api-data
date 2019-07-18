package io.javabrains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



//@SpringBootApplication defines an automatic component scan on package io.javabrains and its subpackages.
@SpringBootApplication
//@EnableDiscoveryClient
public class CourseApiDataApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(CourseApiDataApplication.class, args);
	}
}
