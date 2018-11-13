package com.itek.mapper;

import java.util.List;
import java.util.Map;

import com.itek.entity.CustomerLoss;

/**
 * 客户流失dao接口
 * @author zhangyu
 * @date 2016年9月8日
 */
public interface CustomerLossDao {
	
	/**
	 * 客户流失 列表查询
	 * @param map
	 * @return
	 */
	public List<CustomerLoss> find(Map<String, Object> map);

	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * 增加 客户流失信息
	 * 
	 * @param customerLoss
	 * @return
	 */
	public int add(CustomerLoss customerLoss);

	/**
	 * 通过id查找客户流失信息
	 * 
	 * @param id
	 * @return
	 */
	public CustomerLoss findById(Integer id);

	/**
	 * 更新客户流失信息
	 * 
	 * @param customerLoss
	 * @return
	 */
	public int update(CustomerLoss customerLoss);
	
}
