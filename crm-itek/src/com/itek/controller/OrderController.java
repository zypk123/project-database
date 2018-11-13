package com.itek.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itek.entity.Order;
import com.itek.entity.PageBean;
import com.itek.service.OrderService;
import com.itek.util.DateJsonValueProcessor;
import com.itek.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 客户订单controller控制器
 * 
 * @author zhangyu
 * @date 2016年9月6日
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Resource
	private OrderService orderService; // 注入service

	/**
	 * 客户订单信息 列表查询
	 * 
	 * @param page
	 * @param rows
	 * @param cusId
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public void list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			@RequestParam(value = "cusId", required = false) String cusId, HttpServletResponse response)
			throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cusId", cusId);
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Order> orderList = orderService.find(map);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "customer" }); // 忽略customer属性
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONObject result = new JSONObject();
		Long total = orderService.getTotal(map);
		JSONArray jsonArray = JSONArray.fromObject(orderList, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
	}

	/**
	 * 通过id查找 客户交往信息
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/findById")
	public void findById(@RequestParam(value = "id") String id, HttpServletResponse response) throws Exception {
		Order order = orderService.findById(Integer.parseInt(id));
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "order" }); // 忽略order属性
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONObject jsonObject = JSONObject.fromObject(order, jsonConfig);
		ResponseUtil.write(response, jsonObject);
	}

}
