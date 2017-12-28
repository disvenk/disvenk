package cn.itcast.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.quartz.service.HelloService;

public class HelloJob implements Job {

	//无法注入的问题是说，当前这个类并没有没spring管理，它要注入被spring管理的类是无法成功的
	@Autowired
	private HelloService helloService;

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		helloService.sayHello();
	}

}
