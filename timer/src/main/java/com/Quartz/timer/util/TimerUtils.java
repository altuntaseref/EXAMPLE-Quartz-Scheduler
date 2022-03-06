package com.Quartz.timer.util;

import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import com.Quartz.timer.info.TimerInfo;

public class TimerUtils {
	private TimerUtils() {}
	
	public static JobDetail buildJobDetail(final Class jobClass,final TimerInfo info) {
		
		final JobDataMap jobDataMap=new JobDataMap();
		jobDataMap.put(jobClass.getSimpleName(),info);
		
		return JobBuilder
				.newJob(jobClass)
				.withIdentity(jobClass.getSimpleName())
				.setJobData(jobDataMap)
				.build();
				
	}
	
	public static Trigger buildTrigger(final Class jobClass,final TimerInfo info) {
		SimpleScheduleBuilder builder =SimpleScheduleBuilder //ms cinsinden bir zamanlayıcı oluşturduk
				.simpleSchedule()
				.withIntervalInMilliseconds(info.getRepeatIntervalMs());//verdiğimiz aralık buradan geliyor
		
	
		if(info.isRunForever()) { //sonsuza kadar çalımasını istiyorsak burayı kullanıyoruz
			builder = builder.repeatForever();
			
		} else {
			//kaç kez tekrarlamasını istiyorsak buradan alıyoruz
			//-1 denek ilk ateşleme bize ait demek
			builder =builder.withRepeatCount(info.getTotalFireCount()-1);
		}
		
		return TriggerBuilder
				.newTrigger()
				.withIdentity(jobClass.getSimpleName())
				.withSchedule(builder)
				
				//tam olarak ne zaman aşlamasını isediğimizi söylüyoruz
				.startAt(new Date(System.currentTimeMillis()+info.getInitialOffsetMs()))
				.build();		
		
		
		
		
		
		
		
		
		
		
	
	
	
	}
}
