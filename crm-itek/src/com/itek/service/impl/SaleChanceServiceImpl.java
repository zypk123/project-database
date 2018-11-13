package com.itek.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itek.entity.SaleChance;
import com.itek.mapper.SaleChanceDao;
import com.itek.service.SaleChanceService;

/**
 * 营销机会Service接口 实现类
 * @author zhangyu
 * @date 2016年8月29日
 */
@Service("saleChanceService") // spring负责管理service事务
public class SaleChanceServiceImpl implements SaleChanceService{
	
	@Resource
	SaleChanceDao saleChanceDao; // 引入Dao

	@Override
	public List<SaleChance> find(Map<String, Object> map) {
		return saleChanceDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return saleChanceDao.getTotal(map);
	}

	@Override
	public int add(SaleChance saleChance) {
		return saleChanceDao.add(saleChance);
	}

	@Override
	public int update(SaleChance saleChance) {
		return saleChanceDao.update(saleChance);
	}

	@Override
	public int delete(Integer id) {
		return saleChanceDao.delete(id);
	}

	@Override
	public SaleChance findById(Integer id) {
		return saleChanceDao.findById(id);
	}
	
}
