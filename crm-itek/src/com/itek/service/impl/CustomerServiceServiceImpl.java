package com.itek.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itek.entity.CustomerService;
import com.itek.mapper.CustomerServiceDao;
import com.itek.service.CustomerServiceService;

/**
 * 客户服务Service接口实现类
 * 
 * @author zhangyu
 * @date 2016年9月9日
 */
@Service("customerServiceService")
public class CustomerServiceServiceImpl implements CustomerServiceService {

	@Resource
	CustomerServiceDao customerServiceDao; // 注入dao

	@Override
	public List<CustomerService> find(Map<String, Object> map) {
		return customerServiceDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return customerServiceDao.getTotal(map);
	}

	@Override
	public int add(CustomerService customerService) {
		return customerServiceDao.add(customerService);
	}

	@Override
	public int update(CustomerService customerService) {
		return customerServiceDao.update(customerService);
	}

}
