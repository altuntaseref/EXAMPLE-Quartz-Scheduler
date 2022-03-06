package com.Quartz.timer.timerservice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Quartz.timer.info.TimerInfo;
import com.Quartz.timer.jobs.HelloWorldJob;
import com.Quartz.timer.util.TimerUtils;

@Service
public class SchedulerService {

	private static final Logger LOG = LoggerFactory.getLogger(HelloWorldJob.class);
	
	private final  Scheduler scheduler;
	
	@Autowired
	public SchedulerService(Scheduler scheduler) {
		this.scheduler=scheduler;	
	}
	
	@PostConstruct
	public void init() {
		
		try {
			
			this.scheduler.start();
			
		}catch(SchedulerException e) {
			
			LOG.error(e.getMessage(), e);
			
		}

	}
	
	public void schedule(final Class jobClass,final TimerInfo info) {
		final JobDetail jobDetail =TimerUtils.buildJobDetail(jobClass, info);
		final Trigger trigger = TimerUtils.buildTrigger(jobClass, info);
		
		try {
			scheduler.scheduleJob(jobDetail , trigger);
		} catch (SchedulerException e) {
			LOG.error(e.getMessage(),e);
		}
				
	}
	 
	@PreDestroy
	public void preDestroy() {
		try {
			this.scheduler.shutdown();
		}
		catch (SchedulerException e) {
			LOG.error(e.getMessage(), e);
		}
	}
			
		
	
}
