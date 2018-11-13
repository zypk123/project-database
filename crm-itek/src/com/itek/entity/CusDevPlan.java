package com.itek.entity;

import java.util.Date;

/**
 * 客户开发计划项 实体类
 * 
 * @author zhangyu
 * @date 2016年9月1日
 */
public class CusDevPlan {

	private Integer id; // 开发计划项ID
	private SaleChance saleChance; // 销售机会
	private String planItem; // 计划内容
	private Date planDate; // 计划时间
	private String exeAffect; // 执行效果

	// get/set方法
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SaleChance getSaleChance() {
		return saleChance;
	}

	public void setSaleChance(SaleChance saleChance) {
		this.saleChance = saleChance;
	}

	public String getPlanItem() {
		return planItem;
	}

	public void setPlanItem(String planItem) {
		this.planItem = planItem;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public String getExeAffect() {
		return exeAffect;
	}

	public void setExeAffect(String exeAffect) {
		this.exeAffect = exeAffect;
	}

}
