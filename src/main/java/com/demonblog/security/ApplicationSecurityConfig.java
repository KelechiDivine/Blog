//package com.demonblog.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//import static com.demonblog.security.ApplicationUserRole. *;
////import java.beans.Encoder;
//
//@Configuration
//@EnableWebSecurity
//
//public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	private final PasswordEncoder passwordEncoder;
//
//	@Autowired
//	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder1){
//		this.passwordEncoder = passwordEncoder1;
//	}
//	// press command 'o' to generate this userDetailsService
//
//	@Override
//	@Bean
//	protected UserDetailsService userDetailsService() {
//		UserDetails kelechiDivineUser = User.builder()
//				.username("kelechiDivine")
//				.password(passwordEncoder.encode("keLechi5363@#"))
//				.roles(USER.name()) // ROLES_USER
//				.build();
//
//		UserDetails estherUser = User.builder()
//				.username("Esther")
//				.password(passwordEncoder.encode("iLoveEsther"))
//				.roles(ADMIN.name())
//				.build();
//
//		return new InMemoryUserDetailsManager(
//				kelechiDivineUser,
//				estherUser
//		);
//	}
//
//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception{
//		httpSecurity
//				// Authorize request user
//				.authorizeRequests()
//
//				// anything that has to do with student can only be accessed by  a student
//				.antMatchers("/api/**").hasRole(USER.name())
//
//				// Accept and authorize any request
//				.anyRequest()
//
//				// authenticate all authorized request
//				.authenticated()
//
//				// and
//				.and()
//
//				// authorize basic http request from the web browser
//				.httpBasic();
//	}
//}
