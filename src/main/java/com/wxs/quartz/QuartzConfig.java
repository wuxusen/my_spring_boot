package com.wxs.quartz;

import com.wxs.quartz.job.QuartzConstant;
import com.wxs.quartz.job.QuartzTestJob;
import com.wxs.quartz.job.QuartzTestSecondJob;
import com.wxs.quartz.quartzService.TestQuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Date: 2017年2月22日<br/>
 * 
 * @author sugengbin
 */
@Configuration
@EnableConfigurationProperties({ QuartzConstant.class })
public class QuartzConfig {

	@Autowired
	private QuartzConstant quartzConstant;

	@Autowired
	private TestQuartzService testQuartzService;

	// first JobDetail
	@Bean(name = "firstJobDetailFactoryBean")
	public JobDetailFactoryBean firstJobDetailFactoryBean() {
		JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
		jobDetailFactory.setJobClass(QuartzTestJob.class);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("testQuartzService", testQuartzService);
		jobDetailFactory.setJobDataAsMap(data);
		jobDetailFactory.setDurability(true);
		return jobDetailFactory;
	}

	// first cron trigger
	@Bean(name = "firstCronTriggerFactoryBean")
	public CronTriggerFactoryBean firstCronTriggerFactoryBean(
			@Qualifier("firstJobDetailFactoryBean") JobDetailFactoryBean jobDetailFactory) {
		CronTriggerFactoryBean cronTriggerFactory = new CronTriggerFactoryBean();
		cronTriggerFactory.setCronExpression(quartzConstant.getFirstCron());
		cronTriggerFactory.setJobDetail(jobDetailFactory.getObject());
		return cronTriggerFactory;
	}

	// second JobDetail
	@Bean(name = "secondJobDetailFactoryBean")
	public JobDetailFactoryBean secondJobDetailFactoryBean() {
		JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
		jobDetailFactory.setJobClass(QuartzTestSecondJob.class);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("testQuartzService", testQuartzService);
		jobDetailFactory.setJobDataAsMap(data);
		jobDetailFactory.setDurability(true);
		return jobDetailFactory;
	}

	// second cron trigger
	@Bean(name = "secondCronTriggerFactoryBean")
	public CronTriggerFactoryBean secondCronTriggerFactoryBean(
			@Qualifier("secondJobDetailFactoryBean") JobDetailFactoryBean jobDetailFactory) {
		CronTriggerFactoryBean cronTriggerFactory = new CronTriggerFactoryBean();
		cronTriggerFactory.setCronExpression(quartzConstant.getSecondCron());
		cronTriggerFactory.setJobDetail(jobDetailFactory.getObject());
		return cronTriggerFactory;
	}

	// scheduler factory
	@Bean(name = "schedulerFactoryBean")
	public SchedulerFactoryBean schedulerFactoryBean(
			@Qualifier("firstJobDetailFactoryBean") JobDetailFactoryBean firstJobDetail,
			@Qualifier("secondJobDetailFactoryBean") JobDetailFactoryBean secondJobDetail,
			@Qualifier("firstCronTriggerFactoryBean") CronTriggerFactoryBean firstTrigger,
			@Qualifier("secondCronTriggerFactoryBean") CronTriggerFactoryBean secondTrigger
			) {
		SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
		scheduler.setJobDetails(firstJobDetail.getObject(), secondJobDetail.getObject());
		if (quartzConstant.getEnableFirstTask() == 1 && quartzConstant.getEnableSecondTask() == 0) {
			scheduler.setTriggers(firstTrigger.getObject());
		}
		if (quartzConstant.getEnableFirstTask() == 0 && quartzConstant.getEnableSecondTask() == 1) {
			scheduler.setTriggers(secondTrigger.getObject());
		}
		if (quartzConstant.getEnableFirstTask() == 1 && quartzConstant.getEnableSecondTask() == 1) {
			scheduler.setTriggers(firstTrigger.getObject(), secondTrigger.getObject());
		}
		return scheduler;
	}

}
