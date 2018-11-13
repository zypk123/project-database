package com.itek.mapper;

import java.util.List;
import java.util.Map;

import com.itek.entity.CustomerReprieve;

/**
 * 客户暂缓流失Dao接口
 * 
 * @author zhangyu
 * @date 2016年9月8日
 */
public interface CustomerReprieveDao {

	/**
	 * 客户暂缓流失 列表查询
	 * 
	 * @param map
	 * @return
	 */
	public List<CustomerReprieve> find(Map<String, Object> map);

	/**
	 * 获取总记录数
	 * 
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * 修改暂缓流失客户
	 * 
	 * @param customerReprieve
	 * @return
	 */
	public int update(CustomerReprieve customerReprieve);

	/**
	 * 增加 暂缓流失客户
	 * 
	 * @param customerReprieve
	 * @return
	 */
	public int add(CustomerReprieve customerReprieve);

	/**
	 * 删除暂缓流失客户
	 * 
	 * @param id
	 * @return
	 */
	public int delete(Integer id);

}
