package com.nt.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.WebMvcSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// add username, password and  roles
		/*auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").roles("CUSTOMER").accountLocked(true);
		auth.inMemoryAuthentication().withUser("suresh").password("{noop}hyd").roles("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("rajesh").password("{noop}vizag").roles("VISITOR");
		auth.inMemoryAuthentication().withUser("anil").password("{noop}delhi").roles("CUSTOMER","EMPLOYEE");*/
		
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("raja").password("$2a$10$GGcB2B8pWil34r0mmH7DPuG1tgwI4Ngcpj0Zebe/EYI6qJGA05mcO").roles("CUSTOMER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("suresh").password("$2a$10$KVi10Yx5V8aRB54aIkKjYOc0EFZLuwZhLBW4jfIyE83HRvB.nQwNK").roles("EMPLOYEE");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("rajesh").password("$2a$10$7CGMgS9LvOTAdEpyug0PM.ebQqzeHotK95iibAMKwjmo4Q/.ZVGei").roles("VISITOR");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("anil").password("$2a$10$.Xz7RrGnSTEOd.o8SjxeluH/2qbdWGaCklNmFd655MIYiNErC6IkG").roles("CUSTOMER","EMPLOYEE");
		
		
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests().antMatchers("/").permitAll()  // No Authentication + No Authorization
		         .antMatchers("/offers").hasAnyRole("CUSTOMER","EMPLOYEE","VISITOR")  // Authentication+ Authorization
		         .antMatchers("/balance").hasAnyRole("CUSTOMER","EMPLOYEE")  // Authentication + Authorization
		         .antMatchers("/approve").hasRole("EMPLOYEE")  // Authentication + Authorization
		         .anyRequest().authenticated()  // only Authetication
		         // .and().httpBasic()   // only BASIC Authentication -- makes the browser  generating dialog box asking username,password
		         .and().formLogin()
		         
		         //.and().rememberMe()
		         
		        
		         
		         //.and().logout()
		          .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
		        
		          .and().exceptionHandling().accessDeniedPage("/denied")
		      .and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
		        
		         
	}
    
    
}
