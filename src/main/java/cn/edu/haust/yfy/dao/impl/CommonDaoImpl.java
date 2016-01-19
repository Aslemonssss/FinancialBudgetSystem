package cn.edu.haust.yfy.dao.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.edu.haust.yfy.dao.CommonDao;

import com.dongcun.core.impl.BaseDaoImpl;

@Repository("CommonDao")
public class CommonDaoImpl extends BaseDaoImpl<Object, Integer> implements CommonDao {

	@PersistenceContext(unitName="connectUnit")
	private EntityManager em;
	
	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Long countResult(String sql,Object... args) {
		Session session = em.unwrap(Session.class);
		Query query = session.createSQLQuery(sql);
		query = processQuery(query, args);
		List<BigInteger> objects = query.list();
		return objects.get(0).longValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> queryList(String sql, Object obj, Object... args) {
		Session session = em.unwrap(Session.class);
		Query query = session.createSQLQuery(sql).addEntity(obj.getClass());
		query = processQuery(query, args);
		List<Object> objects = query.list();
		return objects;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Map> queryMapList(String sql, Object... args) {
		Session session = em.unwrap(Session.class);
		Query query = session.createSQLQuery(sql).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		query = processQuery(query, args);
		List<Map> objects = query.list();
		return objects;
	}

	@Override
	public void updateEntity(String sql, Object... args) {
		Session		session = em.unwrap(Session.class);
		Query query = session.createSQLQuery(sql);//executeUpdate();
		query = processQuery(query, args);
		query.executeUpdate();
	}

	/*
	 * 根据可变参数，加工query
	 * @param query
	 * @param args
	 * 更新时间：2015年11月4日09:52:32
	 * */
	private Query processQuery(Query query, Object... args){
		int i = 0;
		for(Object obj : args){
			if(obj instanceof Integer){
				query.setInteger(i, ((Integer) obj).intValue());
				//System.out.println("Integer : "+((Integer) obj).intValue());
			}else if(obj instanceof String){
				query.setString(i, (String) obj);
				//System.out.println("String : "+(String) obj);
			}else if(obj instanceof Double){
				query.setDouble(i, ((Double) obj).doubleValue());
				//System.out.println("Double : "+((Double) obj).doubleValue());
			}else if(obj instanceof Float){
				query.setFloat(i, ((Float) obj).floatValue());
				//System.out.println("Float : "+((Float) obj).floatValue());
			}else if(obj instanceof Long){
				query.setLong(i, ((Long) obj).longValue());
				//System.out.println("Long : "+((Long) obj).longValue());
			}else if(obj instanceof Boolean){
				query.setBoolean(i, ((Boolean) obj).booleanValue());
				//System.out.println("Boolean : "+((Boolean) obj).booleanValue());
			}else if(obj instanceof Date){
				query.setDate(i, (Date) obj);
				//System.out.println("Date : "+(Date) obj);
			}
			i++;
		}
		return query;
	}
}
