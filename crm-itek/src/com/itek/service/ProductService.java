package com.itek.service;

import java.util.List;
import java.util.Map;

import com.itek.entity.Product;

/**
 * 产品Service接口
 * @author zhangyu
 * @date 2016年8月26日
 */
public interface ProductService {
	
	/**
	 * 产品信息查询
	 * @param map
	 * @return
	 */
	public List<Product> find(Map<String,Object> map);
	
	/**
	 * 获取总的产品信息数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);

}
