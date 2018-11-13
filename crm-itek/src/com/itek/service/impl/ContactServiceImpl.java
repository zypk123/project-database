package com.itek.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itek.entity.Contact;
import com.itek.mapper.ContactDao;
import com.itek.service.ContactService;

/**
 * 客户交往记录Service接口实现类
 * 
 * @author zhangyu
 * @date 2016年9月6日
 */
@Service("contactService")
public class ContactServiceImpl implements ContactService {

	@Resource
	ContactDao contactDao; // 注入dao

	@Override
	public List<Contact> find(Map<String, Object> map) {
		return contactDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return contactDao.getTotal(map);
	}

	@Override
	public int add(Contact contact) {
		return contactDao.add(contact);
	}

	@Override
	public int delete(Integer id) {
		return contactDao.delete(id);
	}

	@Override
	public int update(Contact contact) {
		return contactDao.update(contact);
	}

}
