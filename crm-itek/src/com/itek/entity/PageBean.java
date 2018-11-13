package com.itek.entity;

/**
 * 分页实体类
 * 
 * @author zhangyu
 * @date 2016年8月25日
 */
public class PageBean {

	private int page; // 当前页
	private int pageSize; // 页面大小

	public PageBean(int page, int pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 获取页面的第一条数据
	 * 
	 * @return
	 */
	public int getStart() {
		return (page - 1) * pageSize;
	}

}
