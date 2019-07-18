package io.javabrains.logging;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/*Since no url is specified, the filter will intercept all the end points.
 * If the convention-based mapping is not flexible enough, we can use FilterRegistrationBean 
 * for the complete control of the application (see https://www.javadevjournal.com/spring-boot/spring-boot-add-filter/).
 * */
@Component  
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomFilter implements Filter {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(CustomFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOGGER.info("########## Initiating Custom filter ##########");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		  HttpServletResponse response = (HttpServletResponse) servletResponse;
		  
		  LOGGER.info("Logging Request  {} : {}", request.getMethod(), request.getRequestURI());
		//call next filter in the filter chain
		  chain.doFilter(request, response);

		  LOGGER.info("Logging Response :{}", response.getContentType());

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
