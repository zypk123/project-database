package com.itek.service;

import java.util.List;
import java.util.Map;

import com.itek.entity.Order;

/**
 * 客户订单Service接口
 * @author zhangyu
 * @date 2016年9月6日
 */
public interface OrderService {
	
	/**
	 * 客户订单 列表查询
	 * 
	 * @param map
	 * @return
	 */
	public List<Order> find(Map<String, Object> map);

	/**
	 * 获取总记录数
	 * 
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * 通过编号 查找订单
	 * 
	 * @param id
	 * @return
	 */
	public Order findById(Integer id);
	
	

}
