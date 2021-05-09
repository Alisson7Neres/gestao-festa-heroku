package com.gestaofesta.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class InMemorySecurityConfig{

	@Autowired
	public void configureGlobal (AuthenticationManagerBuilder builder)
		throws Exception{
		builder
			   .inMemoryAuthentication()
			   .withUser("alisson").password("{noop}36360").roles("ADMIN");
	}
}
