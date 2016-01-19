package cn.edu.haust.yfy.service;

import java.util.List;
import java.util.Map;

import cn.edu.haust.yfy.dao.CommonDao;

import com.dongcun.core.BaseService;


/*
 * @author : WangDesen
 * 功能：CommonService接口类：通用增删改查方法
 * */
public interface CommonService extends BaseService<Object, Integer, CommonDao> {

	/*
	 * 统计数量
	 * @param sql
	 * @param args
	 * 更新时间：2015年11月4日11:23:01
	 * */
	public Long countResult(String sql, Object... args);
	
	/*
	 * 统计列表-Object
	 * @param sql
	 * @param obj
	 * @param args
	 * 更新时间：2015年11月4日14:10:45
	 * */
	public List<Object> queryList(String sql, Object obj, Object... args);
	
	/*
	 * 统计列表-Map
	 * @param sql
	 * @param args
	 * 更新时间：2015年11月4日17:31:03
	 * */
	@SuppressWarnings("rawtypes")
	public List<Map> queryMapList(String sql, Object... args);
	
	/*
	 * 增删改
	 * @param sql
	 * 更新时间：2015年11月4日17:32:57
	 * */
	public void updateEntity(String sql, Object... args);
	
}
