package com.itek.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.itek.entity.PageBean;
import com.itek.entity.Product;
import com.itek.service.ProductService;
import com.itek.util.ResponseUtil;
import com.itek.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 产品controller控制器
 * @author zhangyu
 * @date 2016年8月26日
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService; // 引入service
	
	/**
	 * 产品信息列表查询
	 * @param page
	 * @param rows
	 * @param s_product
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public void list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, Product s_product, HttpServletResponse response)
			throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productName", StringUtil.formatLike(s_product.getProductName())); //模糊查询，前后加"%"
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Product> productList = productService.find(map);
		Long total = productService.getTotal(map); // 获取总记录数
		JSONObject result = new JSONObject(); 
		JSONArray jsonArray = JSONArray.fromObject(productList);// 将list集合转化成json数组
		result.put("rows", jsonArray);// 将json数组放到json对象中
		result.put("total", total);  
		ResponseUtil.write(response, result);// 将jsonObject写到前台response
	}
	
	

	
	
	
	
	

}
