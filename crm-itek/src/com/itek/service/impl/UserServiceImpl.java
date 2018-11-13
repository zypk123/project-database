package com.itek.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itek.entity.User;
import com.itek.mapper.UserDao;
import com.itek.service.UserService;

/**
 * 用户Service接口实现类
 * @author zhangyu
 * @date 2016年8月24日
 */
@Service("userService")   //spring处理service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao; //引入dao
	
	@Override
	public User login(User user) {
		return userDao.login(user); //登陆
	}

	@Override
	public List<User> find(Map<String, Object> map) {
		return userDao.find(map); //查询
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return userDao.getTotal(map);//获取总记录数
	}

	@Override
	public int add(User user) {
		return userDao.add(user); //添加用户
	} 

	@Override
	public int delete(int id) {
		return userDao.delete(id);//删除用户
	}

	@Override
	public int update(User user) {
		return userDao.update(user);//修改用户
	}

}
