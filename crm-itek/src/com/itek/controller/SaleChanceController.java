package com.itek.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itek.entity.PageBean;
import com.itek.entity.SaleChance;
import com.itek.service.SaleChanceService;
import com.itek.util.DateJsonValueProcessor;
import com.itek.util.ResponseUtil;
import com.itek.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 营销机会管理 控制器Controller
 * 
 * @author zhangyu
 * @date 2016年8月29日
 */
@Controller
@RequestMapping("/saleChance")
public class SaleChanceController {

	@Autowired
	SaleChanceService saleChanceService; // 引入service
	
	/**
	 * 自动转换日期格式类型的数据
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true)); // 
	}

	/**
	 * 查询营销机会列表
	 * 
	 * @param page
	 * @param rows
	 * @param s_saleChance
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public void list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, SaleChance s_saleChance,
			HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("customerName", StringUtil.formatLike(s_saleChance.getCustomerName()));
		map.put("overView", StringUtil.formatLike(s_saleChance.getOverView()));
		map.put("createMan", StringUtil.formatLike(s_saleChance.getCreateMan()));
		map.put("state", s_saleChance.getState());
		map.put("devResult", s_saleChance.getDevResult());
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<SaleChance> saleChanceList = saleChanceService.find(map);
		Long total = saleChanceService.getTotal(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig(); // 创建jsonConfig对象
		// 将前台传来的Date类型的进行格式化
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm"));
		JSONArray jsonArray = JSONArray.fromObject(saleChanceList, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
	}

	/**
	 * 新增或者修改后  保存数据
	 * @param saleChance
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SaleChance saleChance, HttpServletResponse response) throws Exception {
		int resultTotal = 0; // 初始化影响的记录条数
		if (StringUtil.isNotEmpty(saleChance.getAssignMan())) { // 判断是否有指派人
			saleChance.setState(1); // 状态1：已分配
		} else {
			saleChance.setState(0);// 状态0:未分配
		}
		if (saleChance.getId() == null) { // 根据是否传来id判断是新增还是修改
			resultTotal = saleChanceService.add(saleChance); // 新增保存 ，返回被影响的记录条数
		} else {
			resultTotal = saleChanceService.update(saleChance);// 修改保存，返回被影响的记录条数
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
	 * 删除营销机会
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public void delete(@RequestParam(value = "ids") String ids, HttpServletResponse response) throws Exception {
		String[] idsStr = ids.split(","); // 批量删除
		for (int i = 0; i < idsStr.length; i++) {
			saleChanceService.delete(Integer.parseInt(idsStr[i]));
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
	}

	/**
	 * 通过id查找营销机会
	 * 
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findById")
	public void findById(@RequestParam(value = "id") String id, HttpServletResponse response) throws Exception {
		SaleChance saleChance = saleChanceService.findById(Integer.parseInt(id));
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm"));
		JSONObject jsonObject = JSONObject.fromObject(saleChance, jsonConfig);
		ResponseUtil.write(response, jsonObject);
	}

}
