package com.itek.service;

import java.util.List;
import java.util.Map;

import com.itek.entity.Customer;
import com.itek.entity.CustomerFw;
import com.itek.entity.CustomerGc;
import com.itek.entity.CustomerGx;

/**
 * 客户Service接口
 * 
 * @author zhangyu
 * @date 2016年9月5日
 */
public interface CustomerService {

	/**
	 * 列表查询
	 * 
	 * @param map
	 * @return
	 */
	public List<Customer> find(Map<String, Object> map); // map作为查询条件是为了迎合mybatis

	/**
	 * 获取总记录数
	 * 
	 * @param map
	 *            查询条件
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * 添加客户
	 * 
	 * @param user
	 * @return
	 */
	public int add(Customer customer);

	/**
	 * 删除客户
	 * 
	 * @param id
	 *            根据id确定客户
	 * @return
	 */
	public int delete(int id);

	/**
	 * 修改客户
	 * 
	 * @param user
	 * @return
	 */
	public int update(Customer customer);

	/**
	 * 通过id查询客户
	 * 
	 * @param id
	 * @return
	 */
	public Customer findById(Integer id);

	/**
	 * 检查流失客户
	 */
	public void checkCustomerLoss();

	/**
	 * 查询 客户贡献
	 * 
	 * @param map
	 * @return
	 */
	public List<CustomerGx> findCustomerGx(Map<String, Object> map);

	/**
	 * 获取客户贡献总额
	 * 
	 * @param map
	 * @return
	 */
	public Long getTotalCustomerGx(Map<String, Object> map);

	/**
	 * 查询 客户构成
	 * 
	 * @return
	 */
	public List<CustomerGc> findCustomerGc();

	/**
	 * 查询 客户服务
	 * 
	 * @return
	 */
	public List<CustomerFw> findCustomerFw();

}
