package io.javabrains.interceptor;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CourseAPIInterceptor implements HandlerInterceptor{
	
    private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	   public boolean preHandle
	      (HttpServletRequest request, HttpServletResponse response, Object handler) 
	      throws Exception {

	      /*logger.info("Pre Handle method is Calling");
	      String str, wholeStr = "";
	  	try {
	  		BufferedReader br = request.getReader();
	  		while ((str = br.readLine()) != null) {
	  			wholeStr += str;
	  		}
            logger.info("request:" + wholeStr);
	  	} catch (Exception e) {
	  		logger.error("", e);
	  	}*/
	      return true; //if false, the controller won't be called.
	   }
	   @Override
	   public void postHandle(HttpServletRequest request, HttpServletResponse response, 
	      Object handler, ModelAndView modelAndView) throws Exception {
	      
		   logger.info("Post Handle method is Calling");
	   }
	   @Override
	   public void afterCompletion
	      (HttpServletRequest request, HttpServletResponse response, Object 
	      handler, Exception exception) throws Exception {
	      
		   logger.info("Request and Response is completed");
	   }

}
