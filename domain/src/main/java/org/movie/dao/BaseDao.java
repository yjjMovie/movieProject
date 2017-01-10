package org.movie.dao;


import org.movie.utils.HibernateUtil;

import java.util.List;

import javax.persistence.EntityManager;


public class BaseDao<T> {

	public boolean save(T entity){
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		
		try{
			em.persist(entity);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}finally{
			em.close();
		}
		return true;
	}
	
	public boolean remove(T t){

		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		
		try{
			em.remove(em.merge(t));
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}finally{
			em.close();
		}
		return true;
	}
	
	public boolean update(T t){

		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		
		try{
			em.merge(t);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}finally{
			em.close();
		}
		return true;
	}
	
	public T findById(Class<T> entityClass, Object id){

		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		T entity = null;
		try{
			entity = em.find(entityClass, id);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
		return entity;
	}

	public List<T> findList(Class<T> entityClass){
		String jpql = "from " + entityClass.getName();
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		List<T> list = null;
		try{
			list = em.createQuery(jpql).getResultList();
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
		return list;
		
	}
}
