package com.itek.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itek.entity.CustomerReprieve;
import com.itek.service.CustomerReprieveService;
import com.itek.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 客户暂缓流失controller控制器
 * 
 * @author zhangyu
 * @date 2016年9月8日
 */
@Controller
@RequestMapping("/customerReprieve")
public class CustomerReprieveController {

	@Resource
	private CustomerReprieveService customerReprieveService; // 注入service

	/**
	 * 客户暂缓流失 列表查询
	 * 
	 * @param page
	 * @param rows
	 * @param s_customerReprieve
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public void list(@RequestParam(value = "lossId", required = false) String lossId, HttpServletResponse response)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lossId", lossId);
		List<CustomerReprieve> customerReprieveList = customerReprieveService.find(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "customerLoss" }); // 忽略customerLoss
		JSONArray jsonArray = JSONArray.fromObject(customerReprieveList, jsonConfig);
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
	}

	/**
	 * 保存暂缓客户流失数据 新增和修改时保存
	 * 
	 * @param customerReprieve
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(CustomerReprieve customerReprieve, HttpServletResponse response) throws Exception {
		int resultTotal = 0; // 初始化影响的记录条数
		if (customerReprieve.getId() == null) {
			resultTotal = customerReprieveService.add(customerReprieve);
		} else {
			resultTotal = customerReprieveService.update(customerReprieve);
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
	 * 删除暂缓客户信息
	 * 
	 * @param ids
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public void delete(@RequestParam(value = "id") String id, HttpServletResponse response) throws Exception {
		customerReprieveService.delete(Integer.parseInt(id));
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
	}

}
