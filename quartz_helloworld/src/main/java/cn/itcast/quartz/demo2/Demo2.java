package cn.itcast.quartz.demo2;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import cn.itcast.quartz.job.HelloJob;

public class Demo2 {
	public static void main(String[] args) throws SchedulerException {
		// 定时器对象
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

		// 定义一个工作对象
		JobDetail job = JobBuilder.newJob(HelloJob.class)
				.withIdentity("job1",/*工作对象的名称和所在的组*/ "group1").build();
		// 定义触发器
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("trigger1",/*触发器的名字和组*/ "group1").startNow()/*这里可以指定何时执行*/
				.withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5))/*然后就是隔几秒执行一次*/
				.build();

		scheduler.scheduleJob(job, trigger);//scheduler对象的作用就是用来运行job和trigger的
		// 开启定时任务
		scheduler.start();
	}
}
