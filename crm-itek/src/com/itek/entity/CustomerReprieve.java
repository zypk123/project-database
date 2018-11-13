package com.itek.entity;

import com.itek.entity.CustomerLoss;

/**
 * 客户暂缓流失 实体类
 * 
 * @author zhangyu
 * @date 2016年9月8日
 */
public class CustomerReprieve {

	private Integer id; // 编号
	private CustomerLoss customerLoss; // 流失客户
	private String measure; // 暂缓措施

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CustomerLoss getCustomerLoss() {
		return customerLoss;
	}

	public void setCustomerLoss(CustomerLoss customerLoss) {
		this.customerLoss = customerLoss;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

}
