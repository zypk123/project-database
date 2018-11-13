package com.itek.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itek.entity.CustomerReprieve;
import com.itek.mapper.CustomerReprieveDao;
import com.itek.service.CustomerReprieveService;

/**
 * 客户暂缓流失Service接口实现类
 * 
 * @author zhangyu
 * @date 2016年9月8日
 */
@Service("customerReprieveService")
public class CustomerReprieveServiceImpl implements CustomerReprieveService {

	@Resource
	private CustomerReprieveDao CustomerReprieveDao; // 注入dao接口

	@Override
	public List<CustomerReprieve> find(Map<String, Object> map) {
		return CustomerReprieveDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return CustomerReprieveDao.getTotal(map);
	}

	@Override
	public int update(CustomerReprieve customerReprieve) {
		return CustomerReprieveDao.update(customerReprieve);
	}

	@Override
	public int add(CustomerReprieve customerReprieve) {
		return CustomerReprieveDao.add(customerReprieve);
	}

	@Override
	public int delete(Integer id) {
		return CustomerReprieveDao.delete(id);
	}

}
