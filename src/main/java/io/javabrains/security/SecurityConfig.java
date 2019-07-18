package io.javabrains.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	// Authentication : User --> Roles
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		/*String idForEncode = "bcrypt";
		 Map encoders = new HashMap<>();
		 encoders.put(idForEncode, new BCryptPasswordEncoder());
		 PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);*/
		auth.inMemoryAuthentication().withUser("user1").password("{noop}secret1")
				.roles("USER").and().withUser("admin1").password("{noop}secret1")
				.roles("USER", "ADMIN");
	}

	// Authorization : Role -> Access
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().httpBasic().and().authorizeRequests().antMatchers("/topics/**")
				.hasRole("USER");
		/*http.csrf().disable()
        .authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .httpBasic();*/
		 /*super.configure(http);


	     http.csrf().disable();*/
	}

}