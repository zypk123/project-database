package com.itek.entity;

import com.itek.entity.Order;

/**
 * 订单详情明细 实体类
 * 
 * @author zhangyu
 * @date 2016年9月7日
 */
public class OrderDetails {

	private Integer id; // 订单id
	private Order order; // 订单 一对多关系
	private String goodsName; // 商品名称
	private int goodsNum; // 商品数量
	private String unit; // 单位
	private float price; // 价格
	private float sum; // 总计

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getSum() {
		return sum;
	}

	public void setSum(float sum) {
		this.sum = sum;
	}

}
