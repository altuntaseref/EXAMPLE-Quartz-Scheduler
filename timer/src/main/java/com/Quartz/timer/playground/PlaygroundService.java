package com.Quartz.timer.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Quartz.timer.info.TimerInfo;
import com.Quartz.timer.jobs.HelloWorldJob;
import com.Quartz.timer.timerservice.SchedulerService;

@Service
public class PlaygroundService {

	private final SchedulerService schedulerService;
	
	@Autowired
	public PlaygroundService(final SchedulerService schedulerService) {
		
		this.schedulerService =schedulerService;
	}
	
	public void runHelloWorldJob() {
		
		final TimerInfo info = new TimerInfo();
		info.setTotalFireCount(5);
		info.setRepeatIntervalMs(2000);
		info.setInitialOffsetMs(1000);
		info.setCallbackData("My callback data");
		
		schedulerService.schedule(HelloWorldJob.class, info);
		
		 
	}
	
}
