package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.nt.service.IUserInfoMgmtService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	private  IUserInfoMgmtService userService;
	@Autowired
	private  BCryptPasswordEncoder encoder;
	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(encoder);
		
		
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests().antMatchers("/","/bank/","/user/register","/user/showLogin").permitAll()  // No Authentication + No Authorization
		         .antMatchers("/bank/offers").hasAnyAuthority("CUSTOMER","EMPLOYEE","VISITOR")  // Authentication+ Authorization
		         .antMatchers("/bank/balance").hasAnyAuthority("CUSTOMER","EMPLOYEE")  // Authentication + Authorization
		         .antMatchers("/bank/approve").hasAuthority("EMPLOYEE")  // Authentication + Authorization
		         .anyRequest().authenticated()  // only Authetication
		         // .and().httpBasic()   // only BASIC Authentication -- makes the browser  generating dialog box asking username,password
		         .and().formLogin().defaultSuccessUrl("/bank/",true)
		                   .loginPage("/user/showLogin")
		                   .loginProcessingUrl("/login")
		                   .failureUrl("/user/showLogin?error")
		         
		         //.and().rememberMe()
		         
		        
		         
		         //.and().logout()
		          .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout")).logoutSuccessUrl("/user/showLogin?logout")
		        
		          .and().exceptionHandling().accessDeniedPage("/denied")
		      .and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
		        
		         
	}
    
    
}
