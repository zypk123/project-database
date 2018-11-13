package com.itek.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itek.entity.LinkMan;
import com.itek.mapper.LinkManDao;
import com.itek.service.LinkManService;

/**
 * 客户联系人Service接口实现类
 * 
 * @author zhangyu
 * @date 2016年9月6日
 */
@Service("linkManService")
public class LinkManServiceImpl implements LinkManService {

	@Resource
	LinkManDao linkManDao; // 注入dao

	@Override
	public List<LinkMan> find(Map<String, Object> map) {
		return linkManDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return linkManDao.getTotal(map);
	}

	@Override
	public int add(LinkMan linkMan) {
		return linkManDao.add(linkMan);
	}

	@Override
	public int delete(Integer id) {
		return linkManDao.delete(id);
	}

	@Override
	public int update(LinkMan linkMan) {
		return linkManDao.update(linkMan);
	}

}
