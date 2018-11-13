package com.itek.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itek.entity.DataDic;
import com.itek.mapper.DataDicDao;
import com.itek.service.DataDicService;

/**
 * 数据字典Service实现类
 * @author zhangyu
 * @date 2016年8月25日
 */
@Service("dataDicService")  //spring处理service
public class DataDicServiceImpl implements DataDicService {
	
	@Resource
	DataDicDao dataDicDao; //引入dao

	public List<DataDic> find(Map<String, Object> map) {
		return dataDicDao.find(map); // 查询列表（条件）
	}

	@Override
	public List<DataDic> findDataDicName() {
		return dataDicDao.findDataDicName(); // 查询数据字典名
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return dataDicDao.getTotal(map); // 获取总记录数
	}

	@Override
	public int add(DataDic dataDic) {
		return dataDicDao.add(dataDic);//添加数据字典
	}

	@Override
	public int delete(Integer id) {
		return dataDicDao.delete(id);// 删除数据字典
	}

	@Override
	public int update(DataDic dataDic) {
		return dataDicDao.update(dataDic);// 更新数据字典
	}

	@Override
	public List<DataDic> findAll() {
		return dataDicDao.findAll();
	}
	
}
