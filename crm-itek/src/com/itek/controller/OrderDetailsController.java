package com.itek.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itek.entity.OrderDetails;
import com.itek.entity.PageBean;
import com.itek.service.OrderDetailsService;
import com.itek.util.ResponseUtil;
import com.itek.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 订单明细Controller控制器
 * 
 * @author zhangyu
 * @date 2016年9月8日
 */
@Controller
@RequestMapping("/orderDetails")
public class OrderDetailsController {

	@Resource
	OrderDetailsService orderDetailsService; // 注入service

	/**
	 * 订单明细 列表查询
	 * 
	 * @param page
	 * @param rows
	 * @param orderId
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public void list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			@RequestParam(value = "orderId", required = false) String orderId, HttpServletResponse response)
			throws Exception {
		if (StringUtil.isEmpty(orderId)) {
			System.out.println("找不到订单--------");
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderId", orderId);
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<OrderDetails> orderDetailsList = orderDetailsService.find(map);
		Long total = orderDetailsService.getTotal(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(orderDetailsList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
	}

	/**
	 * 获取价格总数
	 * 
	 * @param orderId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getTotalPrice")
	public void getTotalPrice(String orderId, HttpServletResponse response) throws Exception {
		float totalMoney = orderDetailsService.getTotalPriceByOrderId(Integer.parseInt(orderId)); // 通过id找到订单获取总价
		JSONObject result = new JSONObject();
		result.put("totalMoney", totalMoney);
		ResponseUtil.write(response, result);
	}

}
