package com.dongcun.core.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.skyway.spring.util.dao.AbstractJpaDao;

import com.dongcun.core.BaseDao;
import com.dongcun.core.BasePage;
import com.dongcun.core.ReflectionUtils;

public abstract class BaseDaoImpl<T, PK extends Serializable> extends AbstractJpaDao<T> implements BaseDao<T, PK>{
	protected Class<T> entityClass=ReflectionUtils.getSuperClassGenricType(getClass());
	private final Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { entityClass }));

	public BaseDaoImpl() {		
		setDefaultMaxResults(-1);
	}
	
	@Override
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	@Override
	public boolean canBeMerged(T o) {
		return false;
	}
	
	public void deleteById(final PK id) {
		T	entity = findById(id);
		if (null != entity)
			remove(entity);
	}
	
	public T findById(final PK id) {
		return getEntityManager().find(entityClass, id);
	}
	
	private String prepareHqlPart() {
		StringBuilder	builder = new StringBuilder(128);
		builder.append("select o from ");
		builder.append(entityClass.getSimpleName());
		builder.append(" o");
		return builder.toString();
	}
	
	private String prepareHqlFinal(String... property) {
		StringBuilder	builder = new StringBuilder(256);
		builder.append(prepareHqlPart());
		builder.append(" where o.");
/*		builder.append(property);
		builder.append(" = ?");*/
		for (int i = 0; i < property.length; i++) {
			builder.append(property[i]);
			
			if (i == property.length - 1)
				builder.append(" = ?");
			else
				builder.append(" = ? and o.");		
		}
		return builder.toString();
	}
	
	public List<T> findListResultByProperty() {
		String	hql = prepareHqlPart();
		return executeQuery(hql);
	}
	
	public List<T> findListResultByProperty(String property, Object value) {
		String	hql = prepareHqlFinal(property);
		return executeQuery(hql, value);
	}
	
	public T findSingleResultByProperty(String property, Object value) {
		String	hql = prepareHqlFinal(property);
		return executeQuerySingleResult(hql, value);		
	}
	
	public List<T> findListResultByProperty(String[] property, Object... value) {
		String	hql = prepareHqlFinal(property);
		return executeQuery(hql, value);
	}
	
	public List<T>  findListResultByProperty(Map<String, Object> map) {
		List<String>	keys = new ArrayList<String>();
		List<Object>	values = new ArrayList<Object>();
		
		for (String key : map.keySet()) {
			keys.add(key);
			values.add(map.get(key));
		}
		
		String[]	condition = new String[keys.size()];
		keys.toArray(condition);
		Object[]	value = new Object[values.size()];
		values.toArray(value);
		return findListResultByProperty(condition, value);
	}

	public BasePage<T> findAllPage(BasePage<T> page) {
		String	hql = prepareHqlPart();
		List<T>		result = executeQuery(hql);
		page.setRows(result);
		return page;
	}		
	
	public BasePage<T> findPage(BasePage<T> page) {
		String	hql = prepareHqlPart();
		List<T>		result = executeQuery(hql, page.getFirst(), page.getPageSize());
		page.setRows(result);
		return page;
	}
	
	public BasePage<T> findPage(BasePage<T> page, String property, Object value) {
		String	hql = prepareHqlFinal(property);
		List<T>		result = executeQuery(hql, page.getFirst(), page.getPageSize(), value);
		page.setRows(result);		
		return page;		
	}
	
	public BasePage<T> findPage(BasePage<T> page, String[] property, Object... value) {
		String	hql = prepareHqlFinal(property);
		List<T>		result = executeQuery(hql, page.getFirst(), page.getPageSize(), value);
		page.setRows(result);
		return page;
	}
	
	public BasePage<T>  findPage(BasePage<T> page, Map<String, Object> map) {
		List<String>	keys = new ArrayList<String>();
		List<Object>	values = new ArrayList<Object>();
		
		for (String key : map.keySet()) {
			keys.add(key);
			values.add(map.get(key));
		}
		
		String[]	condition = new String[keys.size()];
		keys.toArray(condition);
		Object[]	value = new Object[values.size()];
		values.toArray(value);
		return findPage(page, condition, value);
	}	
	
	private String prepareCountHqlPart() {
		StringBuilder	builder = new StringBuilder(128);
		builder.append("select count(*) from ");
		builder.append(entityClass.getSimpleName());
		builder.append(" o");
		return builder.toString();
	}
	
	private String prepareCountHqlFinal(String... property) {
		StringBuilder	builder = new StringBuilder(256);
		builder.append(prepareCountHqlPart());
		builder.append(" where o.");
/*		builder.append(property);
		builder.append(" = ?");*/
		for (int i = 0; i < property.length; i++) {
			builder.append(property[i]);
			
			if (i == property.length - 1)
				builder.append(" = ?");
			else
				builder.append(" = ? and o.");		
		}
		return builder.toString();
	}
	
	public Long countResult() {
		String	countHql = prepareCountHqlPart();
		Long	count = (Long) executeQuerySingleResult(countHql);
		return count;
	}

	public Long countResult(String property, Object... value) {
		String	countHql = prepareCountHqlFinal(property);
		Long	count = (Long) executeQuerySingleResult(countHql, value);
		return count;
	}	
	
	public Long countResult(String[] property, Object... value) {
		String	countHql = prepareCountHqlFinal(property);
		Long	count = (Long) executeQuerySingleResult(countHql, value);
		return count;
	}
	
	public Long countResult(Map<String, Object> map) {
		List<String>	keys = new ArrayList<String>();
		List<Object>	values = new ArrayList<Object>();
		
		for (String key : map.keySet()) {
			keys.add(key);
			values.add(map.get(key));
		}
		
		String[]	condition = new String[keys.size()];
		keys.toArray(condition);
		Object[]	value = new Object[values.size()];
		values.toArray(value);
		return countResult(condition, value);		
	}
}
