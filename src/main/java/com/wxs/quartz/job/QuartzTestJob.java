package com.wxs.quartz.job;

import com.wxs.quartz.quartzService.TestQuartzService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 
 *
 * Date: 2017年2月22日<br/>
 * 
 * @author sugengbin
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class QuartzTestJob extends QuartzJobBean {

	private final static Logger logger = LoggerFactory.getLogger(QuartzTestJob.class);

	private TestQuartzService testQuartzService = null;

	/**
	 * 
	 * @param context
	 */
	protected void init(JobExecutionContext context) {
		final JobDataMap jobDataMap = context.getMergedJobDataMap();
		testQuartzService = (TestQuartzService) jobDataMap.get("testQuartzService");
	}


	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		init(context);
		testQuartzService.execu();
	}

}
