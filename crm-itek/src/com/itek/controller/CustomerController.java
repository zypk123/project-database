package com.itek.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itek.entity.Customer;
import com.itek.entity.CustomerFw;
import com.itek.entity.CustomerGc;
import com.itek.entity.CustomerGx;
import com.itek.entity.PageBean;
import com.itek.service.CustomerService;
import com.itek.util.DateUtil;
import com.itek.util.ResponseUtil;
import com.itek.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 客户信息Controller控制器
 * 
 * @author zhangyu
 * @date 2016年9月5日
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Resource
	CustomerService customerService; // 注入service

	/**
	 * 客户信息列表查询
	 * 
	 * @param page
	 * @param rows
	 * @param s_customer
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public void list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, Customer s_customer,
			HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("khno", StringUtil.formatLike(s_customer.getKhno())); // 模糊查询，前后加"%"
		map.put("name", StringUtil.formatLike(s_customer.getName())); // 模糊查询，前后加"%"
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Customer> customerList = customerService.find(map);
		Long total = customerService.getTotal(map);
		JSONObject result = new JSONObject(); // json对象
		JSONArray jsonArray = JSONArray.fromObject(customerList);// 将list集合转化成json数组
		result.put("rows", jsonArray);// 将json数组放到jsonObject
		result.put("total", total);// 传递记录总数total到jsonObject
		ResponseUtil.write(response, result);// 将jsonObject写到前台response
	}

	/**
	 * 保存数据 新增和修改
	 * 
	 * @param customer
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(Customer customer, HttpServletResponse response) throws Exception {
		int resultTotal = 0; // 初始化影响的记录条数
		if (customer.getId() == null) { // 如果没有id，则是新增
			customer.setKhno("KH" + DateUtil.getCurrentDateStr()); // 客户编码的形式为:KH+当前时间，eg:KH20160905
			resultTotal = customerService.add(customer); // 新增
		} else {
			resultTotal = customerService.update(customer); // 修改
		}
		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
	}

	/**
	 * 删除客户信息
	 * 
	 * @param ids
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public void delete(@RequestParam(value = "ids") String ids, HttpServletResponse response) throws Exception {
		String[] idsStr = ids.split(","); // 批量删除
		for (int i = 0; i < idsStr.length; i++) {
			customerService.delete(Integer.parseInt(idsStr[i])); // 根据id删除客户信息
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
	}

	/**
	 * 通过id查找客户信息
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/findById")
	public void findById(@RequestParam(value = "id") String id, HttpServletResponse response) throws Exception {
		Customer customer = customerService.findById(Integer.parseInt(id));
		JSONObject jsonObject = JSONObject.fromObject(customer); // 将Customer对象转化成Json
		ResponseUtil.write(response, jsonObject);
	}

	/**
	 * 查询 客户贡献
	 * 
	 * @param page
	 * @param rows
	 * @param s_customerGx
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/findCustomerGx")
	public void findCustomerGx(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, CustomerGx s_customerGx,
			HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", StringUtil.formatLike(s_customerGx.getName())); // 查询条件
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<CustomerGx> customerGxList = customerService.findCustomerGx(map);// 查询客户贡献
		Long total = customerService.getTotalCustomerGx(map); // 获取客户贡献总额
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(customerGxList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
	}

	/**
	 * 查询 客户构成
	 * 
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/findCustomerGc")
	public void findCustomerGc(HttpServletResponse response) throws Exception {
		List<CustomerGc> customerGcList = customerService.findCustomerGc();
		JSONArray jsonArray = JSONArray.fromObject(customerGcList);
		ResponseUtil.write(response, jsonArray);
	}

	/**
	 * 查询 客户服务
	 * 
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/findCustomerFw")
	public void findCustomerFw(HttpServletResponse response) throws Exception {
		List<CustomerFw> customerFwList = customerService.findCustomerFw();
		JSONArray jsonArray = JSONArray.fromObject(customerFwList);
		ResponseUtil.write(response, jsonArray);
	}

}
