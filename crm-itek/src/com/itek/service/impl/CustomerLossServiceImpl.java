package com.itek.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itek.entity.CustomerLoss;
import com.itek.mapper.CustomerLossDao;
import com.itek.service.CustomerLossService;

/**
 * 客户流失Service接口实现类
 * 
 * @author zhangyu
 * @date 2016年9月8日
 */
@Service("customerLossService")
public class CustomerLossServiceImpl implements CustomerLossService {

	@Resource
	CustomerLossDao customerLossDao; // 引入dao

	@Override
	public List<CustomerLoss> find(Map<String, Object> map) {
		return customerLossDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return customerLossDao.getTotal(map);
	}

	@Override
	public int add(CustomerLoss customerLoss) {
		return customerLossDao.add(customerLoss);
	}

	@Override
	public CustomerLoss findById(Integer id) {
		return customerLossDao.findById(id);
	}

	@Override
	public int update(CustomerLoss customerLoss) {
		return customerLossDao.update(customerLoss);
	}

}
