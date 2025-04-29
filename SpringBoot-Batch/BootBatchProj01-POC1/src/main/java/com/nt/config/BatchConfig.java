//BatchConfig.java
package com.nt.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nt.listener.JobMonitoringListener;
import com.nt.processor.BookItemProcessor;
import com.nt.reader.BookItemReader;
import com.nt.writer.BookItemWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private  JobBuilderFactory  jobFactory;
	@Autowired
	private  StepBuilderFactory  stepFactory;
	@Autowired
	private  BookItemReader  reader;
	@Autowired
     private  BookItemProcessor  processor;
	@Autowired
	private   BookItemWriter  writer;
	@Autowired
	private  JobMonitoringListener  listener;
	
	
	@Bean(name="step1")
	public  Step  createStep1() {
		return  stepFactory.get("step1")
				     .<String,String>chunk(3)
				     .reader(reader)
				     .writer(writer)
				     .processor(processor)
				     .build();
				     
	}
	
	@Bean(name="job1")
	public  Job  createJob1() {
		   return  jobFactory.get("job1")
				        .incrementer(new RunIdIncrementer())
				        .listener(listener)
				        .start(createStep1())
				        .build();
	}
	
	
	

}
