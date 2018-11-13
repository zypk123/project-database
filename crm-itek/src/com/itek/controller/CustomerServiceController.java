package com.itek.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itek.entity.CustomerService;
import com.itek.entity.PageBean;
import com.itek.service.CustomerServiceService;
import com.itek.util.DateJsonValueProcessor;
import com.itek.util.ResponseUtil;
import com.itek.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 客户服务Controller控制器
 * 
 * @author zhangyu
 * @date 2016年9月9日
 */
@Controller
@RequestMapping("/customerService")
public class CustomerServiceController {

	@Resource
	CustomerServiceService customerServiceService; // 注入Service

	/**
	 * 自动绑定时间类型并格式化
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	/**
	 * 客户服务 列表查询
	 * 
	 * @param page
	 * @param rows
	 * @param s_customerService
	 * @param createTimefrom
	 * @param createTimeto
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public void list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, CustomerService s_customerService,
			String createTimefrom, String createTimeto, HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("customer", StringUtil.formatLike(s_customerService.getCustomer())); // 查询条件
		map.put("overview", StringUtil.formatLike(s_customerService.getOverview())); // 查询条件
		map.put("serveType", s_customerService.getServeType()); // 查询条件
		map.put("state", s_customerService.getState()); // 查询条件
		map.put("createTimefrom", createTimefrom); // 查询条件
		map.put("createTimeto", createTimeto); // 查询条件
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<CustomerService> customerServiceList = customerServiceService.find(map);
		Long total = customerServiceService.getTotal(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(customerServiceList, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
	}

	/**
	 * 保存数据 用于修改和新增后进行保存
	 * 
	 * @param customerService
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(CustomerService customerService, HttpServletResponse response) throws Exception {
		int resultTotal = 0; // 初始化影响的记录条数
		if (customerService.getId() == null) { // 判断是否存在id
			resultTotal = customerServiceService.add(customerService); // 添加
		} else {
			resultTotal = customerServiceService.update(customerService); // 修改
		}
		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
	}

}
