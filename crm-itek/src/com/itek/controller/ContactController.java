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

import com.itek.entity.Contact;
import com.itek.service.ContactService;
import com.itek.util.DateJsonValueProcessor;
import com.itek.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 客户 交往记录Controller控制器
 * 
 * @author zhangyu
 * @date 2016年9月6日
 */
@Controller
@RequestMapping("/contact")
public class ContactController {

	@Resource
	ContactService contactService; // 注入service

	/**
	 * 格式化日期格式function
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // true:���������ֵ��false:����Ϊ��ֵ
	}

	/**
	 * 客户交往记录 列表查询
	 * 
	 * @param cusId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public void list(@RequestParam(value = "cusId", required = false) String cusId, HttpServletResponse response)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cusId", cusId); // cusId对应customer
		List<Contact> contactList = contactService.find(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		// 格式化前台传来的时间类型的数据
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		jsonConfig.setExcludes(new String[] { "customer" }); // setExcludes():里面就是需要过滤掉的属性,过滤customer属性
		JSONArray jsonArray = JSONArray.fromObject(contactList, jsonConfig);
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
	}

	/**
	 * 保存 新增和修改后保存
	 * 
	 * @param contact
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(Contact contact, HttpServletResponse response) throws Exception {
		int resultTotal = 0; // 初始化影响的记录条数
		if (contact.getId() == null) { // 如果id为空的话，为新增，否则，为更新
			resultTotal = contactService.add(contact); // 新增
		} else {
			resultTotal = contactService.update(contact); // 修改
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
	 * 删除 客户交往记录
	 * 
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public void delete(@RequestParam(value = "id") String id, HttpServletResponse response) throws Exception {
		contactService.delete(Integer.parseInt(id));
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
	}

}
