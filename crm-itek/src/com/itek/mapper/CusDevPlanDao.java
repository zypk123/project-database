package com.itek.mapper;

import java.util.List;
import java.util.Map;

import com.itek.entity.CusDevPlan;

/**
 * 客户开发计划Dao接口
 * @author zhangyu
 * @date 2016年9月1日
 */
public interface CusDevPlanDao {
	
	/**
	 * 客户开发计划列表查询
	 * @param map
	 * @return
	 */
	public List<CusDevPlan> find(Map<String,Object> map);
	
	/**
	 * 获取总的记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	/**
	 * 添加 客户开发计划
	 * @param cusDevPlan
	 * @return
	 */
	public int add(CusDevPlan cusDevPlan);
	
	/**
	 * 删除 客户开发计划
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
	
	/**
	 * 修改客户开发计划
	 * @param cusDevPlan
	 * @return
	 */
	public int update(CusDevPlan cusDevPlan);
	
}
