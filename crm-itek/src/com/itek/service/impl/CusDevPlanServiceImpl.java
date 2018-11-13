package com.itek.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itek.entity.CusDevPlan;
import com.itek.mapper.CusDevPlanDao;
import com.itek.service.CusDevPlanService;

/**
 * 客户开发计划项Service接口实现类
 * 
 * @author zhangyu
 * @date 2016年9月1日
 */
@Service("cusDevPlanService") // spring处理Service事务
public class CusDevPlanServiceImpl implements CusDevPlanService {

	@Resource
	CusDevPlanDao cusDevPlanDao; // 引入dao

	@Override
	public List<CusDevPlan> find(Map<String, Object> map) {
		return cusDevPlanDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return cusDevPlanDao.getTotal(map);
	}

	@Override
	public int add(CusDevPlan cusDevPlan) {
		return cusDevPlanDao.add(cusDevPlan);
	}

	@Override
	public int delete(Integer id) {
		return cusDevPlanDao.delete(id);
	}

	@Override
	public int update(CusDevPlan cusDevPlan) {
		// TODO Auto-generated method stub
		return 0;
	}

}
