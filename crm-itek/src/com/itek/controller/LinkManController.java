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

import com.itek.entity.LinkMan;
import com.itek.service.LinkManService;
import com.itek.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 客户联系人 controller控制器
 * 
 * @author zhangyu
 * @date 2016年9月6日
 */
@Controller
@RequestMapping("/linkMan")
public class LinkManController {

	@Resource
	LinkManService linkManService; // 注入Service
	
	/**
	 * 格式化时间类型的数据方法
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
	}

	/**
	 * 客户联系人 列表查询
	 * 
	 * @param cusId
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public void list(@RequestParam(value = "cusId", required = false) String cusId, HttpServletResponse response)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cusId", cusId); // cusId与customer关联
		List<LinkMan> linkManList = linkManService.find(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "customer" }); // setExcludes():里面就是需要过滤掉的属性,过滤customer属性
		JSONArray jsonArray = JSONArray.fromObject(linkManList, jsonConfig);
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
	}

	/**
	 * 保存 新增和修改
	 * 
	 * @param linkMan
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(LinkMan linkMan, HttpServletResponse response) throws Exception {
		int resultTotal = 0; // 初始化影响的记录条数
		if (linkMan.getId() == null) { // 如果没有id，则是新增
			resultTotal = linkManService.add(linkMan); // 新增
		} else {
			resultTotal = linkManService.update(linkMan); // 修改
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
	 * 删除 客户联系人
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public void delete(@RequestParam(value = "id") String id, HttpServletResponse response) throws Exception {
		linkManService.delete(Integer.parseInt(id));
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
	}

}
