package com.nt.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.nt.listener.JobMonitoringListener;
import com.nt.model.IExamResult;
import com.nt.model.OExamResult;
import com.nt.processor.ExamResultItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobBuilderFactory  jobFactory;
	@Autowired
	private  StepBuilderFactory stepFactory;
	@Autowired
	private EntityManagerFactory factory;
	@Autowired
	private JobMonitoringListener listener;
	@Autowired
	private  ExamResultItemProcessor processor;
	
	//reader object
	@Bean
	public   FlatFileItemReader<IExamResult> createReader(){
		return  new FlatFileItemReaderBuilder<IExamResult>()
				             .name("reader")
				             .resource(new ClassPathResource("TopBrains.csv"))
				             .delimited().delimiter(",")
				             .names("id","dob","semester","percentage")
				             .targetType(IExamResult.class)
				             .build();
	}
	
	//writer object
	@Bean
	public   JpaItemWriter<OExamResult> createWriter(){
		return  new  JpaItemWriterBuilder<OExamResult>()
				     .entityManagerFactory(factory)
				     .build();
	}
	
	//step object
	@Bean(name="step1")
	public  Step  createStep1() {
		return  stepFactory.get("step1")
				     .<IExamResult,OExamResult>chunk(10)
				     .reader(createReader())
				     .writer(createWriter())
				     .processor(processor)
				     .build();
				     
	}
	
	// Job object
	@Bean(name="job1")
	public  Job  createJob1() {
		   return  jobFactory.get("job1")
				         .listener(listener)
				        .incrementer(new RunIdIncrementer())
				        .start(createStep1())
				        .build();
	}
	
	
	

}
