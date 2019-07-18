package io.javabrains.logging;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestInterceptor extends HandlerInterceptorAdapter{
	
	 @Override
	    public boolean preHandle(
	      HttpServletRequest request, 
	      HttpServletResponse response, 
	      Object handler) {
	        return true;
	    }
	 
	    @Override
	    public void afterCompletion(
	      HttpServletRequest request, 
	      HttpServletResponse response, 
	      Object handler, 
	      Exception ex) {
	        //
	    }

}
