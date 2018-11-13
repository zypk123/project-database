package com.itek.mapper;

import java.util.List;
import java.util.Map;

import com.itek.entity.LinkMan;

/**
 * 客户联系人Dao接口
 * 
 * @author zhangyu
 * @date 2016年9月6日
 */
public interface LinkManDao {

	/**
	 * 查询联系人列表
	 * 
	 * @param map
	 * @return
	 */
	public List<LinkMan> find(Map<String, Object> map);

	/**
	 * 获取总记录数
	 * 
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * 新增 联系人
	 * 
	 * @param linkMan
	 * @return
	 */
	public int add(LinkMan linkMan);

	/**
	 * 根据id 删除联系人
	 * 
	 * @param id
	 * @return
	 */
	public int delete(Integer id);

	/**
	 * 修改 联系人
	 * 
	 * @param linkMan
	 * @return
	 */
	public int update(LinkMan linkMan);

}
