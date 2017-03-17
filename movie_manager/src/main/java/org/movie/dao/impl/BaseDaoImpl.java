package org.movie.dao.impl;

import org.movie.dao.BaseDao;
import org.movie.entity.Movie;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/03/16.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public void save(T entity) {
        em.persist(entity);
    }

    @Override
    public void remove(T entity) {
        em.remove(em.merge(entity));
    }

    @Override
    public void update(T entity) {
        em.merge(entity);
    }

    @Override
    public T findById(Class<T> entityClass, Serializable id) {
        return em.find(entityClass, id);
    }

    @Override
    public List<T> findList(Class<T> entityClass) {
        String jpql = "from "+entityClass.getName();
        return em.createQuery(jpql).getResultList();
    }

}
