package com.itek.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itek.entity.OrderDetails;
import com.itek.mapper.OrderDetailsDao;
import com.itek.service.OrderDetailsService;

/**
 * 订单详情Service接口实现类
 * @author zhangyu
 * @date 2016年9月7日
 */
@Service("/orderDetails")
public class OrderDetailsServiceImpl implements OrderDetailsService {
	
	@Resource
	OrderDetailsDao orderDetailsDao; // 注入dao

	@Override
	public List<OrderDetails> find(Map<String, Object> map) {
		return orderDetailsDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return orderDetailsDao.getTotal(map);
	}

	@Override
	public float getTotalPriceByOrderId(Integer orderId) {
		return orderDetailsDao.getTotalPriceByOrderId(orderId);
	}
	
	

}
