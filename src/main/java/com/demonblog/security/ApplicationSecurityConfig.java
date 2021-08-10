package com.demonblog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity

public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	// press command 'o' to generate this userDetailsService
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		return super.userDetailsService();
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity
				// Authorize request user
				.authorizeRequests()
				
				// Accept and authorize any request
				.anyRequest()
				
				// authenticate all authorized request
				.authenticated()
				
				// and
				.and()
				
				// authorize basic http request from the web browser
				.httpBasic();
	}
}
