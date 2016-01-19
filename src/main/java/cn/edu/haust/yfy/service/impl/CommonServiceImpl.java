package cn.edu.haust.yfy.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.haust.yfy.dao.CommonDao;
import cn.edu.haust.yfy.service.CommonService;

import com.dongcun.core.impl.BaseServiceImpl;

@Service("CommonService")
public class CommonServiceImpl extends BaseServiceImpl<Object, Integer, CommonDao>
		implements CommonService {
	
	@Override
	@Resource(name="CommonDao")
	public void setEntityDao(CommonDao entityDao){
		this.entityDao = entityDao;
	}

	@Override
	public Long countResult(String sql, Object... args) {
		return entityDao.countResult(sql, args);
	}

	@Override
	public List<Object> queryList(String sql, Object obj, Object... args) {
		return entityDao.queryList(sql, obj, args);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> queryMapList(String sql, Object... args) {
		return entityDao.queryMapList(sql, args);
	}

	@Override
	public void updateEntity(String sql, Object... args) {
		entityDao.updateEntity(sql, args);
	}

}
