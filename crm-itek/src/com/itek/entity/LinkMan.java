package com.itek.entity;

import com.itek.entity.Customer;

/**
 * 客户联系人实体类
 * 
 * @author zhangyu
 * @date 2016年9月6日
 */
public class LinkMan {

	private Integer id; // 联系人Id
	private Customer customer; // 客户   一对多关系
	private String linkName; // 联系人姓名
	private String sex; // 联系人性别
	private String zhiwei; // 联系人职位
	private String officePhone; // 联系人办公电话
	private String phone; // 手机号码

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getZhiwei() {
		return zhiwei;
	}

	public void setZhiwei(String zhiwei) {
		this.zhiwei = zhiwei;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
