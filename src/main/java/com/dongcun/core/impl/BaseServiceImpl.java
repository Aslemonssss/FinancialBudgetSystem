package com.dongcun.core.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dongcun.core.BaseDao;
import com.dongcun.core.BasePage;
import com.dongcun.core.BaseService;

@Transactional
public abstract class BaseServiceImpl<T, PK extends Serializable, EntityDao extends BaseDao<T, PK>> implements BaseService<T, PK, EntityDao> {
	protected EntityDao	entityDao;
	 
	public abstract void setEntityDao(EntityDao entityDao); 
	
	public T save(T entity) {
		return entityDao.store(entity);
	}
	
	public T update(T entity) {
		return entityDao.merge(entity);
	}
	
	public void delete(T entity) {
		entityDao.remove(entity);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)	
	public T findById(final PK id) {
		return entityDao.findById(id);
	}
	
	public void deleteById(final PK id) {
		entityDao.deleteById(id);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)	
	public List<T> findListResultByProperty() {
		return entityDao.findListResultByProperty();
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)	
	public List<T> findListResultByProperty(String property, Object value) {
		return entityDao.findListResultByProperty(property, value);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)	
	public T findSingleResultByProperty(String property, Object value) {
		return entityDao.findSingleResultByProperty(property, value);		
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<T> findListResultByProerty(String[] property, Object... value) {
		return entityDao.findListResultByProperty(property, value);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<T> findListResultByProerty(Map<String, Object> map) {
		return entityDao.findListResultByProperty(map);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public BasePage<T> findAllPage(BasePage<T> page) {
		return entityDao.findAllPage(page);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public BasePage<T> findPage(BasePage<T> page) {
		return entityDao.findPage(page);
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public BasePage<T> findPage(BasePage<T> page, String property, Object value) {
		return entityDao.findPage(page, property, value);
	}	
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public BasePage<T> findPage(BasePage<T> page, String[] property, Object... value) {
		return entityDao.findPage(page, property, value);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public BasePage<T>  findPage(BasePage<T> page, Map<String, Object> map) {
		return entityDao.findPage(page, map);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Long countResult() {
		return entityDao.countResult();
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Long countResult(String property, Object... value) {
		return entityDao.countResult(property, value);
	}	
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Long countResult(String[] property, Object... value) {
		return entityDao.countResult(property, value);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Long countResult(Map<String, Object> map) {
		return entityDao.countResult(map);
	}
}
