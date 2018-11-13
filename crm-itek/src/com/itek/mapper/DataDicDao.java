package com.itek.mapper;

import java.util.List;
import java.util.Map;

import com.itek.entity.DataDic;

/**
 * 数据字典Dao接口
 * @author zhangyu
 * @date 2016年8月25日
 */
public interface DataDicDao {
	
	/**
	 * 查询数据字典列表   带有查询条件
	 * @param map
	 * @return
	 */
	public List<DataDic> find(Map<String,Object> map); //带有查询条件的查询
	
	/**
	 * 查询数据字典列表  不带查询条件
	 * @return
	 */
	public List<DataDic> findAll();
	
	/**
	 * 查询数据字典名  为了初始化数据字典名下拉框
	 * @return
	 */
	public List<DataDic> findDataDicName();
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	/**
	 * 添加数据字典
	 * @param dataDic
	 * @return
	 */
	public int add(DataDic dataDic);
	
	/**
	 * 删除数据字典
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
	
	/**
	 * 更新数据字典
	 * @param dataDic
	 * @return
	 */
	public int update(DataDic dataDic);
	
	
	

}
