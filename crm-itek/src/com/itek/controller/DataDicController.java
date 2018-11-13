package com.itek.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itek.entity.DataDic;
import com.itek.entity.PageBean;
import com.itek.service.DataDicService;
import com.itek.util.ResponseUtil;
import com.itek.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 数据字典controller控制器
 * 
 * @author zhangyu
 * @date 2016年8月25日
 */
@Controller
@RequestMapping("/datadic")
public class DataDicController {

	@Autowired
	DataDicService dataDicService;// 引入service

	/**
	 * 查询数据字典列表
	 * 
	 * @param page
	 * @param rows
	 * @param s_dataDic
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public void list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, DataDic s_dataDic,
			HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows)); // 创建分页对象
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataDicName", s_dataDic.getDataDicName());
		map.put("dataDicValue", StringUtil.formatLike(s_dataDic.getDataDicValue())); // 模糊查询加"%"
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<DataDic> dataDicList = dataDicService.find(map);
		Long total = dataDicService.getTotal(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(dataDicList);// 将list转化成json数组
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result); // 将jsonObject传递到前台
	}

	/**
	 * 保存数据字典信息 用于添加和修改后保存数据
	 * 
	 * @param dataDic
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(DataDic dataDic, HttpServletResponse response) throws Exception {
		int resultTotal = 0; // 影响的记录数
		if (dataDic.getId() == null) { // 没有id，说明是添加
			resultTotal = dataDicService.add(dataDic); // 添加保存
		} else {
			resultTotal = dataDicService.update(dataDic);// 修改保存
		}
		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result); // 把jsonObject对象写到前台页面
	}

	/**
	 * 删除数据字典
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "ids") String ids, HttpServletResponse response) throws Exception {
		String[] idsStr = ids.split(","); // 逗号分隔前台传来的id字符串数组
		for (int i = 0; i < idsStr.length; i++) {
			dataDicService.delete(Integer.parseInt(idsStr[i]));
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}

	/**
	 * 查询数据字典名 为下拉框添加数据
	 * 
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataDicComboList")
	public void dataDicComboList(String dataDicName, HttpServletResponse response) throws Exception {
		JSONArray jsonArray = new JSONArray();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataDicName", dataDicName);
		List<DataDic> dataDicList = dataDicService.find(map);
		JSONArray rows = JSONArray.fromObject(dataDicList);
		jsonArray.addAll(rows);
		ResponseUtil.write(response, jsonArray);
	}
	
	/**
	 * 查询 数据字典名
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/findDataDicName")
	public void dataDicNameComboList(HttpServletResponse response) throws Exception {
		JSONArray jsonArray = new JSONArray();
		List<DataDic> dataDicList = dataDicService.findAll();
		JSONArray rows = JSONArray.fromObject(dataDicList); 
		jsonArray.addAll(rows);
		ResponseUtil.write(response, jsonArray);
	}
	
	
	
	

}
