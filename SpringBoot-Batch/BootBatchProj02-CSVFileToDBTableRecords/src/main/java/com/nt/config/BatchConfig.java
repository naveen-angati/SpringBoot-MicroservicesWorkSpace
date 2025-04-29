//BatchConfig.java
package com.nt.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;

import com.nt.listener.JobMonitoringListener;
import com.nt.model.Employee;
import com.nt.processor.EmployeeItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private  JobBuilderFactory  jobFactory;
	@Autowired
	private  StepBuilderFactory  stepFactory;
	 @Autowired
     private  EmployeeItemProcessor  processor;
	 @Autowired
	 private  JobMonitoringListener listener;
	 @Autowired
	 private  DataSource ds;
	 
		/*	 @Bean
			 public  FlatFileItemReader<Employee>  createReader() {
				 //create object for the above
				 FlatFileItemReader<Employee>  reader=new FlatFileItemReader<Employee>();
				 //sepcify the resource (csv file name)
				 reader.setResource(new ClassPathResource("Employee.csv"));
				 // set LineMapper
				 reader.setLineMapper(new DefaultLineMapper<Employee>() {{
					 
					 //set LineTokenizer
					  setLineTokenizer(new DelimitedLineTokenizer() {{
						   setDelimiter(",");
						   setNames("eno","ename","eadd","salary");
					  }});
					  //set FieldSetMapper
					  setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>(){{
						  setTargetType(Employee.class);
					  }});
					 
				 }});
				 return reader;
			 }//method
		*/	 
	 
	    @Bean
	     public   FlatFileItemReader<Employee>  createReader(){
	    	 return   new FlatFileItemReaderBuilder<Employee>()
	    			             .name("file-reader")
	    			             .resource(new ClassPathResource("Employee.csv"))
	    			             .delimited()
	    			             .names("eno","ename","eadd","salary")
	    			             .targetType(Employee.class)
	    			             .build();
	     }
	 
		/* @Bean
		 public  FlatFileItemReader<Employee>  createReader() {
			 //create object for the above
			 FlatFileItemReader<Employee>  reader=new FlatFileItemReader<Employee>();
			 //sepcify the resource (csv file name)
			 reader.setResource(new ClassPathResource("Employee.csv"));
			 // set the  Line mapper
			 DefaultLineMapper<Employee> lineMapper=new DefaultLineMapper<Employee>();
			 //set LineTokenizer  to Linemapper
			 DelimitedLineTokenizer tokenizer=new DelimitedLineTokenizer();
			 tokenizer.setDelimiter(",");
			 tokenizer.setNames("eno","ename","eadd","salary");
			 lineMapper.setLineTokenizer(tokenizer);
			 //set  FielSetMapper to LineMapper
			 BeanWrapperFieldSetMapper<Employee> wrapper=new BeanWrapperFieldSetMapper<Employee>();
			 wrapper.setTargetType(Employee.class);
			 lineMapper.setFieldSetMapper(wrapper);
			 //set LineMapper  to reader
			 reader.setLineMapper(lineMapper);
		    return reader;		 
		 }*/
	
		/*@Bean
		public  JdbcBatchItemWriter<Employee>  createWriter(){
		 //create the object for JdbcBatchItemWriter 
		 JdbcBatchItemWriter<Employee> writer=new JdbcBatchItemWriter<Employee>();
		 //set DataSource
		 writer.setDataSource(ds);
		 //set SQL Query with named Params
		 writer.setSql("INSERT INTO BATCH_EMPLOYEE_INFO VALUES(:eno,:ename,:eadd,:salary,:grossSalary,:netSalary)");
		 //set Model class obj data to  SQL Query Named Param values
		 BeanPropertyItemSqlParameterSourceProvider<Employee> sourceProvider=new BeanPropertyItemSqlParameterSourceProvider<Employee>();
		 writer.setItemSqlParameterSourceProvider(sourceProvider);
		 return writer;
		}*/
	 
		/* @Bean
		 public    JdbcBatchItemWriter<Employee> createWriter(){
			 //create object for JdbcBatchItemWriter
			  JdbcBatchItemWriter<Employee> writer=new JdbcBatchItemWriter<Employee>() {{
				    setDataSource(ds);
				    setSql("INSERT INTO BATCH_EMPLOYEE_INFO VALUES(:eno,:ename,:eadd,:salary,:grossSalary,:netSalary)" );
				    setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
			  }};
			  
			 return writer;
		 }*/
	    
	    @Bean
		 public    JdbcBatchItemWriter<Employee> createWriter(){
	    	return  new JdbcBatchItemWriterBuilder<Employee>()
	    			       .dataSource(ds)
	    			       .sql("INSERT INTO BATCH_EMPLOYEE_INFO VALUES(:eno,:ename,:eadd,:salary,:grossSalary,:netSalary)")
	    			       .beanMapped()
	    			       .build();
	    			       
	    			     
	    			        
	    	
	    }
	
	@Bean(name="step1")
	public  Step  createStep1() {
		return  stepFactory.get("step1")
				     .<Employee,Employee>chunk(10)
				     .reader(createReader())
				     .writer(createWriter())
				     .processor(processor)
				     .build();
				     
	}
	
	@Bean(name="job1")
	public  Job  createJob1() {
		   return  jobFactory.get("job1")
				         .listener(listener)
				        .incrementer(new RunIdIncrementer())
				        .start(createStep1())
				        .build();
	}
	
	
	

}
