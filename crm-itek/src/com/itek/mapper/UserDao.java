package com.itek.mapper;

import java.util.List;
import java.util.Map;

import com.itek.entity.User;

/**
 * 用户Dao接口
 * @author zhangyu
 * @date 2016年8月24日
 */
public interface UserDao {
	
	/**
	 * 登陆
	 * @param user
	 * @return
	 */
	public User login(User user); 
	
	/**
	 * 查询用户列表
	 * @param map 查询条件
	 * @return
	 */
	public List<User> find(Map<String,Object> map); //map作为查询条件是为了迎合mybatis
	
	/**
	 * 获取总记录数
	 * @param map 查询条件
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int add(User user);
	
	/**
	 * 删除用户
	 * @param id 根据id确定用户
	 * @return
	 */
	public int delete(int id);
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public int update(User user);
	
}
