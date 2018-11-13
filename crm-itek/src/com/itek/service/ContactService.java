package com.itek.service;

import java.util.List;
import java.util.Map;

import com.itek.entity.Contact;

/**
 * 客户交往记录Service接口
 * 
 * @author zhangyu
 * @date 2016年9月6日
 */
public interface ContactService {

	/**
	 * 查询交往记录列表
	 * 
	 * @param map
	 * @return
	 */
	public List<Contact> find(Map<String, Object> map);

	/**
	 * 获取总记录数
	 * 
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * 新增 交往记录
	 * @param contact
	 * @return
	 */
	public int add(Contact contact);

	/**
	 * 根据id 删除交往记录
	 * 
	 * @param id
	 * @return
	 */
	public int delete(Integer id);

	/**
	 * 修改 交往记录
	 * @param contact
	 * @return
	 */
	public int update(Contact contact);

}
