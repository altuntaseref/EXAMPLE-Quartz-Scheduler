package com.Quartz.timer.jobs;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.Quartz.timer.info.TimerInfo;

@Component
public class HelloWorldJob implements Job{

	private static final Logger LOG = LoggerFactory.getLogger(HelloWorldJob.class);
	
	@Override
	public void execute(JobExecutionContext context)   {
		JobDataMap jobDataMap =context.getJobDetail().getJobDataMap();
		TimerInfo info =(TimerInfo) jobDataMap.get(HelloWorldJob.class.getSimpleName());
		LOG.info(info.getCallbackData());
		
	}

}
