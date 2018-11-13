package com.itek.entity;

import java.util.Date;

/**
 * 客户服务 实体类
 * 
 * @author zhangyu
 * @date 2016年9月9日
 */
public class CustomerService {

	private Integer id; // 客户服务id
	private String serveType; // 服务类型
	private String overview; // 概要
	private String customer; // 客户
	private String state; // 状态
	private String servicerequest; // 服务请求
	private String createPeople; // 创建人
	private Date createTime; // 创建时间
	private String assigner; // 指派人
	private Date assignTime; // 指派时间
	private String serviceProce; // 服务处理
	private String serviceProcePeople; // 服务处理人
	private Date serviceProceTime; // 服务处理时间
	private String serviceProceResult; // 服务处理结果
	private String myd; // 客户满意度

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServeType() {
		return serveType;
	}

	public void setServeType(String serveType) {
		this.serveType = serveType;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getServicerequest() {
		return servicerequest;
	}

	public void setServicerequest(String servicerequest) {
		this.servicerequest = servicerequest;
	}

	public String getCreatePeople() {
		return createPeople;
	}

	public void setCreatePeople(String createPeople) {
		this.createPeople = createPeople;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAssigner() {
		return assigner;
	}

	public void setAssigner(String assigner) {
		this.assigner = assigner;
	}

	public Date getAssignTime() {
		return assignTime;
	}

	public void setAssignTime(Date assignTime) {
		this.assignTime = assignTime;
	}

	public String getServiceProce() {
		return serviceProce;
	}

	public void setServiceProce(String serviceProce) {
		this.serviceProce = serviceProce;
	}

	public String getServiceProcePeople() {
		return serviceProcePeople;
	}

	public void setServiceProcePeople(String serviceProcePeople) {
		this.serviceProcePeople = serviceProcePeople;
	}

	public Date getServiceProceTime() {
		return serviceProceTime;
	}

	public void setServiceProceTime(Date serviceProceTime) {
		this.serviceProceTime = serviceProceTime;
	}

	public String getServiceProceResult() {
		return serviceProceResult;
	}

	public void setServiceProceResult(String serviceProceResult) {
		this.serviceProceResult = serviceProceResult;
	}

	public String getMyd() {
		return myd;
	}

	public void setMyd(String myd) {
		this.myd = myd;
	}

}
