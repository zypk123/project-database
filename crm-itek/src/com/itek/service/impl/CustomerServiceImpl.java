package com.itek.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itek.entity.Customer;
import com.itek.entity.CustomerFw;
import com.itek.entity.CustomerGc;
import com.itek.entity.CustomerGx;
import com.itek.entity.CustomerLoss;
import com.itek.entity.Order;
import com.itek.mapper.CustomerDao;
import com.itek.mapper.CustomerLossDao;
import com.itek.mapper.OrderDao;
import com.itek.service.CustomerService;

/**
 * 客户Service接口实现类
 * 
 * @author zhangyu
 * @date 2016年9月5日
 */
@Service("customerService") // spring处理service事务
public class CustomerServiceImpl implements CustomerService {

	@Resource
	CustomerDao customerDao; // 注入dao

	@Resource
	private CustomerLossDao customerLossDao; // 注入dao

	@Resource
	private OrderDao orderDao; // 注入dao

	@Override
	public List<Customer> find(Map<String, Object> map) {
		return customerDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return customerDao.getTotal(map);
	}

	@Override
	public int add(Customer customer) {
		return customerDao.add(customer);
	}

	@Override
	public int delete(int id) {
		return customerDao.delete(id);
	}

	@Override
	public int update(Customer customer) {
		return customerDao.update(customer);
	}

	@Override
	public Customer findById(Integer id) {
		return customerDao.findById(id);
	}

	@Override
	public List<CustomerGx> findCustomerGx(Map<String, Object> map) {
		return customerDao.findCustomerGx(map);
	}

	@Override
	public Long getTotalCustomerGx(Map<String, Object> map) {
		return customerDao.getTotalCustomerGx(map);
	}

	@Override
	public List<CustomerGc> findCustomerGc() {
		return customerDao.findCustomerGc();
	}

	@Override
	public List<CustomerFw> findCustomerFw() {
		return customerDao.findCustomerFw();
	}

	@Override
	public void checkCustomerLoss() {
		List<Customer> customerList = customerDao.findLossCustomer();
		for (Customer c : customerList) {
			CustomerLoss customerLoss = new CustomerLoss();
			customerLoss.setCusNo(c.getKhno());// 获取客户编号
			customerLoss.setCusName(c.getName()); // 获取客户姓名
			customerLoss.setCusManager(c.getCusManager()); // 获取客户经理
			Order order = orderDao.findLastOrderByCusId(c.getId());
			if (order == null) {
				customerLoss.setLastOrderTime(null);
			} else {
				customerLoss.setLastOrderTime(order.getOrderDate());
			}
			customerLossDao.add(customerLoss);
			c.setState(1);// 状态1：流失客户
			customerDao.update(c); // 更新
		}
	}

}
