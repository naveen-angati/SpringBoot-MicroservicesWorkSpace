package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	private  DataSource ds;
	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(ds).passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("SELECT UNAME,PWD,STATUS FROM USERS WHERE UNAME=?")
		.authoritiesByUsernameQuery("SELECT UNAME,USER_ROLE FROM USERS_ROLES WHERE UNAME=?");
		
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests().antMatchers("/").permitAll()  // No Authentication + No Authorization
		         .antMatchers("/offers").hasAnyAuthority("CUSTOMER","EMPLOYEE","VISITOR")  // Authentication+ Authorization
		         .antMatchers("/balance").hasAnyAuthority("CUSTOMER","EMPLOYEE")  // Authentication + Authorization
		         .antMatchers("/approve").hasAuthority("EMPLOYEE")  // Authentication + Authorization
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
