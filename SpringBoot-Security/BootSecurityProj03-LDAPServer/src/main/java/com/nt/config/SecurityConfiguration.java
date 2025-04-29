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
	
	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		  auth.ldapAuthentication().contextSource().url("ldap://localhost:10389/o=nit")
		          .managerDn("uid=admin,ou=system").managerPassword("secret")  //for connection
		          .and()
		          .userSearchBase("ou=users").userSearchFilter("(cn={0})")  //for authentication
		          .groupSearchBase("ou=roles").groupSearchFilter("(uniqueMember={0})")
		          .groupRoleAttribute("cn").rolePrefix("ROLE_"); //for authorization
		
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests().antMatchers("/").permitAll()  // No Authentication + No Authorization
		         .antMatchers("/offers").hasAnyRole("CUSTOMER","Employee","VISITOR")  // Authentication+ Authorization
		         .antMatchers("/balance").hasAnyRole("CUSTOMER","Employee")  // Authentication + Authorization
		         .antMatchers("/approve").hasRole("Employee")  // Authentication + Authorization
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
