//SpringBatchTestRunner.java
package com.nt.test;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SpringBatchTest  {
	@Autowired
	private JobLauncher launcher;
	@Autowired
	private Job  job;

	 @Scheduled(cron ="${cron.expr}")
	public void  scheduleJob()  throws Exception {
		JobParameters params=new JobParametersBuilder()
				                                .addLong("time", System.currentTimeMillis()).toJobParameters();
		JobExecution execution=launcher.run(job, params);
		System.out.println("Job Execution status ::"+execution.getExitStatus());
		System.out.println("Job started at::"+execution.getStartTime()+"   "+execution.getEndTime());
		
	}

	

}
