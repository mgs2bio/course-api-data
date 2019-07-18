package io.javabrains.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Component
public class CourseAPIInterceptorAppConfig extends WebMvcConfigurerAdapter{
	

	@Autowired
	CourseAPIInterceptor courseApiInterceptor;
	

   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(courseApiInterceptor).addPathPatterns("/**/topics/**/");
   }

}
