package com.nt.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Component
public class MVCConfigurer implements WebMvcConfigurer {
	
	/*	@Override
		public void configureViewResolvers(ViewResolverRegistry registry) {
			  InternalResourceViewResolver resolver=new InternalResourceViewResolver();
			  resolver.setPrefix("/WEB-INF/pages/");
			  resolver.setSuffix(".jsp");
			  registry.viewResolver(resolver);
		}*/

}
