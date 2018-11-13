package com.itek.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itek.entity.Product;
import com.itek.mapper.ProductDao;
import com.itek.service.ProductService;

/**
 * 产品Service接口实现类
 * @author zhangyu
 * @date 2016年8月26日
 */
@Service("productService") //spring处理service事务
public class ProductServiceImpl implements ProductService{
	
	@Resource
	ProductDao productDao; // 引入Dao

	@Override
	public List<Product> find(Map<String, Object> map) {
		return productDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return productDao.getTotal(map);
	}
	
}
