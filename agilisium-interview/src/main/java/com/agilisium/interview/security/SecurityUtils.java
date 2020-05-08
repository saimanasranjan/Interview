package com.agilisium.interview.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityUtils extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("priyanka").password("{noop}priyanka2020").roles("USER");
		auth.inMemoryAuthentication().withUser("amresh").password("{noop}amresh2020").roles("USER");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
	  http.csrf().disable()
	  	.authorizeRequests()
	  	.antMatchers("/getproductdetails").hasRole("USER")
	  	.antMatchers("/getconfigdetails").hasRole("USER")
	  	.anyRequest().authenticated()
		.and().httpBasic()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);;
 	}
	
	

}
