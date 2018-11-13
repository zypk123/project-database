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

import com.itek.entity.CusDevPlan;
import com.itek.entity.SaleChance;
import com.itek.service.CusDevPlanService;
import com.itek.service.SaleChanceService;
import com.itek.util.DateJsonValueProcessor;
import com.itek.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 客户开发计划控制器Controller
 * 
 * @author zhangyu
 * @date 2016年9月1日
 */
@Controller
@RequestMapping("/cusDevPlan")
public class CusDevPlanController {

	@Resource
	CusDevPlanService cusDevPlanService; // 注入service

	@Resource
	private SaleChanceService saleChanceService;

	/**
	 * 格式化日期
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
	 * 查询客户开发计划 列表
	 * 
	 * @param saleChanceId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public void list(@RequestParam(value = "saleChanceId", required = false) String saleChanceId,
			HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("saleChanceId", saleChanceId);
		List<CusDevPlan> cusDevPlanList = cusDevPlanService.find(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "saleChance" });
		// 注册时间格式转化
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(cusDevPlanList, jsonConfig); // list转化为jsonArray
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
	}

	/**
	 * 保存数据 新增和修改后保存
	 * 
	 * @param cusDevPlan
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(CusDevPlan cusDevPlan, HttpServletResponse response) throws Exception {
		int resultTotal = 0; // 初始化影响的记录条数
		if (cusDevPlan.getId() == null) { // 如果没有客户开发计划ID
			SaleChance saleChance = new SaleChance();
			saleChance.setId(cusDevPlan.getSaleChance().getId());
			saleChance.setDevResult(1); // 设置开发状态为1：未开发
			saleChanceService.update(saleChance);
			resultTotal = cusDevPlanService.add(cusDevPlan); // 添加
		} else {
			resultTotal = cusDevPlanService.update(cusDevPlan); // 存在ID则是更新
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
	 * 删除客户开发计划
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public void delete(@RequestParam(value = "id") String id, HttpServletResponse response) throws Exception {
		cusDevPlanService.delete(Integer.parseInt(id));
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
	}

	/**
	 * 更改客户开发项的开发状态
	 * 
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateSaleChanceDevResult")
	public void updateSaleChanceDevResult(@RequestParam(value = "id") String id,
			@RequestParam(value = "devResult") String devResult, HttpServletResponse response) throws Exception {
		SaleChance saleChance = new SaleChance();
		saleChance.setId(Integer.parseInt(id));
		saleChance.setDevResult(Integer.parseInt(devResult));
		int resultTotal = saleChanceService.update(saleChance);
		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
	}

}
