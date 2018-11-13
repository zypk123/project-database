package com.itek.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itek.entity.CustomerLoss;
import com.itek.entity.PageBean;
import com.itek.service.CustomerLossService;
import com.itek.util.DateJsonValueProcessor;
import com.itek.util.ResponseUtil;
import com.itek.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 客户流失Controller控制器
 * 
 * @author zhangyu
 * @date 2016年9月8日
 */
@Controller
@RequestMapping("/customerLoss")
public class CustomerLossController {

	@Resource
	CustomerLossService customerLossService; // 注入service

	/**
	 * 客户流失 列表查询
	 * 
	 * @param page
	 * @param rows
	 * @param s_customerLoss
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public void list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, CustomerLoss s_customerLoss,
			HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cusName", StringUtil.formatLike(s_customerLoss.getCusName())); // 查询条件
		map.put("cusManager", StringUtil.formatLike(s_customerLoss.getCusManager())); // 查询条件
		map.put("state", s_customerLoss.getState()); // 查询条件
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<CustomerLoss> customerLossList = customerLossService.find(map);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd")); // 格式化日期
		JSONObject result = new JSONObject();
		Long total = customerLossService.getTotal(map);
		JSONArray jsonArray = JSONArray.fromObject(customerLossList, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
	}

	/**
	 * 通过id查找客户流失信息
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/findById")
	public void findById(@RequestParam(value = "id") String id, HttpServletResponse response) throws Exception {
		CustomerLoss customerLoss = customerLossService.findById(Integer.parseInt(id));
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));// 格式化日期
		JSONObject jsonObject = JSONObject.fromObject(customerLoss, jsonConfig);
		ResponseUtil.write(response, jsonObject);
	}

	/**
	 * 确认流失操作
	 * 
	 * @param id
	 * @param lossReason
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/confirmLoss")
	public void confirmLoss(int id, String lossReason, HttpServletResponse response) throws Exception {
		CustomerLoss customerLoss = new CustomerLoss();
		customerLoss.setId(id);
		customerLoss.setLossReason(lossReason);
		customerLoss.setConfirmLossTime(new Date()); // 流失时间是当前操作时间
		customerLoss.setState(1); // 状态1：确认流失
		customerLossService.update(customerLoss);
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
	}

}
