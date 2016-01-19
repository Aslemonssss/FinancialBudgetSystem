package com.dongcun.core;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseService<T, PK extends Serializable, EntityDao extends BaseDao<T, PK>> {

	public abstract void setEntityDao(EntityDao entityDao);

	public abstract T save(T entity);

	public abstract T update(T entity);

	public abstract void delete(T entity);

	public abstract T findById(PK id);

	public abstract void deleteById(PK id);
	
	public abstract List<T> findListResultByProperty();
	
	public abstract List<T> findListResultByProperty(String property, Object value);
	
	public abstract T findSingleResultByProperty(String property, Object value);
	
	public abstract List<T> findListResultByProerty(String[] property, Object... value);
	
	public abstract List<T> findListResultByProerty(Map<String, Object> map);
	
	public abstract BasePage<T> findAllPage(BasePage<T> page);
	
	public abstract BasePage<T> findPage(BasePage<T> page);
	
	public abstract BasePage<T> findPage(BasePage<T> page, String property, Object value);
	
	public abstract BasePage<T> findPage(BasePage<T> page, String[] property, Object... value);
	
	public abstract BasePage<T>  findPage(BasePage<T> page, Map<String, Object> map);
		
	public abstract Long countResult();

	public abstract Long countResult(String property, Object... value);		
	
	public abstract Long countResult(String[] property, Object... value);
	
	public abstract Long countResult(Map<String, Object> map);
}