package com.itek.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itek.entity.Order;
import com.itek.mapper.OrderDao;
import com.itek.service.OrderService;

/**
 * 客户订单Service接口实现类
 * 
 * @author zhangyu
 * @date 2016年9月6日
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Resource
	private OrderDao orderDao; // 注入dao

	@Override
	public List<Order> find(Map<String, Object> map) {
		return orderDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return orderDao.getTotal(map);
	}

	@Override
	public Order findById(Integer id) {
		return orderDao.findById(id);
	}

}
