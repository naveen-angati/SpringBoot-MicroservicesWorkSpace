package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{
	
	@Bean    //acts the  AuthenticationInfoProvider
	public UserDetailsService   createUserDetails(){
		//add users having username, password and Role
		 UserDetails user1=User.builder().username("raja").password("{noop}rani").roles("CUSTOMER").build();
		 UserDetails user2=User.builder().username("suresh").password("{noop}hyd").roles("EMPLOYEE","CUSTOMER").build();
		 UserDetails user3=User.builder().username("rajesh").password("{noop}delhi").roles("EMPLOYEE").build();
		 UserDetails user4=User.builder().username("anil").password("{noop}vizag").roles("VISITOR").build();
		 
		 return new InMemoryUserDetailsManager(user1,user2,user3,user4);
	}
	
	@Bean
	public   SecurityFilterChain    createFilterChain(HttpSecurity http)throws Exception {
		http.authorizeHttpRequests((req)->req.
			       requestMatchers(new AntPathRequestMatcher("/")).permitAll()
				/*
				 * .requestMatchers(new
				 * AntPathRequestMatcher("/offers")).hasAnyAuthority("EMPLOYEE","CUSTOMER",
				 * "VISITOR") .requestMatchers(new
				 * AntPathRequestMatcher("/balance")).hasAnyAuthority("CUSTOMER","EMPLOYEE")
				 * .requestMatchers(new
				 * AntPathRequestMatcher("/approve")).hasAuthority("EMPLOYEE")
				 */
			      .anyRequest().authenticated())
		          .formLogin((form)->form.permitAll())
		          .rememberMe((me)->me.alwaysRemember(true))
		          .logout((logout)-> logout.permitAll())
		          .exceptionHandling((exp)->exp.accessDeniedPage("/denied"))
		          .sessionManagement((ses)->ses.maximumSessions(2).maxSessionsPreventsLogin(true));
		
		   return http.build();
		          
		          
		
	}
    
}
