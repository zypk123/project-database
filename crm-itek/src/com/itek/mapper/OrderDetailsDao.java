package com.itek.mapper;

import java.util.List;
import java.util.Map;

import com.itek.entity.OrderDetails;

/**
 * 订单详情Dao接口
 * 
 * @author zhangyu
 * @date 2016年9月7日
 */
public interface OrderDetailsDao {

	/**
	 * 订单详情 列表查询
	 * 
	 * @param map
	 * @return
	 */
	public List<OrderDetails> find(Map<String, Object> map);

	/**
	 * 获取总记录数
	 * 
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * 通过订单id获取价格总数
	 * 
	 * @param orderId
	 * @return
	 */
	public float getTotalPriceByOrderId(Integer orderId);

}
