package com.nt;

import java.util.ResourceBundle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@SpringBootApplication
public class BootMvcProj03SeasonAppDataRendering1Application {
	
	/*	@Bean
		public  InternalResourceViewResolver createViewResolver() {
			InternalResourceViewResolver resolver=new InternalResourceViewResolver();
			resolver.setPrefix("/WEB-INF/pages/");
			resolver.setSuffix(".jsp");
			return resolver;
		}*/
	
	/*@Bean
	 public  UrlBasedViewResolver  createResolver() {
		UrlBasedViewResolver resolver=new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		//resolver.setViewClass(JstlView.class);
		resolver.setViewClass(InternalResourceView.class);
		return resolver;
	}*/
	
	@Bean
	public  ResourceBundleViewResolver createRBVResolver() {
		  ResourceBundleViewResolver resolver=new ResourceBundleViewResolver();
		  return resolver;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj03SeasonAppDataRendering1Application.class, args);
	}

}
