package com.nt.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	  @Bean
	    public Docket createDocket() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.basePackage("com.nt.rest"))              
	          .paths(PathSelectors.regex("/tourist-api.*"))       
	          .build()
	          .useDefaultResponseMessages(true)
	          .apiInfo(getAPIInfo());
	    }
	  
	  private   ApiInfo  getAPIInfo() {
		  Contact contact=new Contact("raja", "http://www.license.come", "raja@rani.com");
		  return  new ApiInfo("TouristAPI",
				                             "API for Tourist operations",
				                              "1.0",
				                              "http://www.terms.com", contact, "GNU-License", "http://nataraz.com/gnu-license", 
				                               Collections.emptyList() );
	  }

}
