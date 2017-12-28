package cn.itcast.quartz.demo3;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import cn.itcast.quartz.job.HelloJob;

public class Demo3 {
	public static void main(String[] args) throws SchedulerException {
		// 定时器对象
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

		// 定义一个工作对象
		JobDetail job = JobBuilder.newJob(HelloJob.class)
				.withIdentity("job1", /**/"group1").build();
		// 定义触发器
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("trigger1", "group1")/**/
				.withSchedule(CronScheduleBuilder.cronSchedule("0 0 0 ? * *"))
				.build();

		scheduler.scheduleJob(job, trigger);
		// 开启定时任务
		scheduler.start();
	}
}
