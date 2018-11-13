package com.itek.service;

import java.util.List;
import java.util.Map;

import com.itek.entity.CustomerService;

/**
 * 客户服务Service接口
 * @author zhangyu
 * @date 2016年9月9日
 */
public interface CustomerServiceService {
	
	/**
	 * 客户服务列表展示
	 * 
	 * @param map
	 * @return
	 */
	public List<CustomerService> find(Map<String, Object> map);

	/**
	 * 获取总记录数
	 * 
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * 添加 客户服务
	 * 
	 * @param customerService
	 * @return
	 */
	public int add(CustomerService customerService);

	/**
	 * 修改 客户服务
	 * 
	 * @param customerService
	 * @return
	 */
	public int update(CustomerService customerService);
	
	
	

}
