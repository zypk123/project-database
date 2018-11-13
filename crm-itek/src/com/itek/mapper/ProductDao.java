package com.itek.mapper;

import java.util.List;
import java.util.Map;

import com.itek.entity.Product;

/**
 * 产品Dao接口
 * @author zhangyu
 * @date 2016年8月26日
 */
public interface ProductDao {
	
	/**
	 * 产品信息查询
	 * @param map
	 * @return
	 */
	public List<Product> find(Map<String,Object> map);
	
	/**
	 * 获取总的产品记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
 
}
