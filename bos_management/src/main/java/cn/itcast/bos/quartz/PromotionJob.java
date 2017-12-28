package cn.itcast.bos.quartz;



import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.bos.service.take_delivery.PromotionService;
import cn.itcast.bos.service.take_delivery.WayBillService;


public class PromotionJob implements Job {

	//无法注入的问题是说，当前这个类并没有没spring管理，它要注入被spring管理的类是无法成功的
	@Autowired
	private PromotionService promotionService;
	
	@Autowired
	private WayBillService wayBillService;
	
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		promotionService.updateStatus(new Date());
		promotionService.show();
		wayBillService.syncIndex();
	}

}
