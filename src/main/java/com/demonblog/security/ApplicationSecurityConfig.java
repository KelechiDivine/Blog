package com.demonblog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@Configuration
@EnableWebSecurity

public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final PasswordEncoder passwordEncoder;
	
	
	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder1){
		this.passwordEncoder = passwordEncoder1;
	}
	// press command 'o' to generate this userDetailsService
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails firstUser = User.builder()
				.username("Kelechi")
				.password("password")
				.roles("Blog_User") // ROLES_BLOG_USER
				.build();
		
		return new InMemoryUserDetailsManager(
				firstUser
		);
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
