package cn.edu.haust.yfy.dao;

import java.util.List;
import java.util.Map;

import com.dongcun.core.BaseDao;

/*
 * @author : WangDesen
 * 功能：CommonDao接口类：通用增删改查方法
 * */
public interface CommonDao extends BaseDao<Object, Integer> {

	/*
	 * 查数目
	 * @param sql
	 * @param args
	 * 更新时间：2015年11月4日12:09:10
	 * */
	public Long countResult(String sql,Object... args);
	
	/*
	 * 查列表-Object
	 * @param sql
	 * @param obj
	 * @param args
	 * 更新时间：2015年11月4日12:10:22
	 * */
	public List<Object> queryList(String sql, Object obj, Object... args);
	
	/*
	 * 查列表-Map
	 * @param sql
	 * @param args
	 * 更新时间：2015年11月4日17:25:05
	 * */
	@SuppressWarnings("rawtypes")
	public List<Map> queryMapList(String sql, Object... args);
	
	/*
	 * 增,删,改
	 * @param sql
	 * @param args
	 * 更新时间：2015年11月5日09:50:57
	 * */
	public void updateEntity(String sql, Object... args);
	
}
