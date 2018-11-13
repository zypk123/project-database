package com.itek.entity;

import java.util.Date;

import com.itek.entity.Customer;

/**
 * 客户交往记录实体类
 * 
 * @author zhangyu
 * @date 2016年9月6日
 */
public class Contact {

	private Integer id; // 交往记录id
	private Customer customer; // 客户 一对多关系
	private Date contactTime; // 交往时间
	private String address; // 交往地址
	private String overView; // 概要

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

	public Date getContactTime() {
		return contactTime;
	}

	public void setContactTime(Date contactTime) {
		this.contactTime = contactTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOverView() {
		return overView;
	}

	public void setOverView(String overView) {
		this.overView = overView;
	}

}
