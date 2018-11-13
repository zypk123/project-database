package com.itek.quartz;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.itek.service.CustomerService;

/**
 * 定时任务 : 查询流失客户 业务规定：6个月没有下单的用户为流失客户
 * 
 * @author zhangyu
 * @date 2016年9月9日
 */
@Component
public class FindLossCustomerJob {

	@Resource
	CustomerService customerService; // 注入service

	@Scheduled(cron = "0 0 2 * * ?")   // 这里表示每天凌晨两点执行一次，具体使用方法,baidu下quartz定时任务
	public void work() {
		customerService.checkCustomerLoss(); // service调用
	}

}
