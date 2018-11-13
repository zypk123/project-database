package com.itek.service;

import java.util.List;
import java.util.Map;

import com.itek.entity.SaleChance;

/**
 * 营销机会 Service接口
 * 
 * @author zhangyu
 * @date 2016年8月29日
 */
public interface SaleChanceService {

	/**
	 * 查询营销机会列表
	 * 
	 * @param map
	 * @return
	 */
	public List<SaleChance> find(Map<String, Object> map);

	/**
	 * 获取总记录数
	 * 
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * 添加销售机会
	 * 
	 * @param saleChance
	 * @return
	 */
	public int add(SaleChance saleChance);

	/**
	 * 修改销售机会
	 * 
	 * @param saleChance
	 * @return
	 */
	public int update(SaleChance saleChance);

	/**
	 * 删除销售机会
	 * 
	 * @param id
	 * @return
	 */
	public int delete(Integer id);

	/**
	 * 通过id查找销售机会
	 * 
	 * @param id
	 * @return
	 */
	public SaleChance findById(Integer id);

}
