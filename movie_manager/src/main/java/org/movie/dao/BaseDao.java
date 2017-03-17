package org.movie.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/03/16.
 */
public interface BaseDao<T> {

    public void save(T entity);

    public void remove(T entity);

    public void update(T entity);

    public T findById(Class<T> entityClass, Serializable id);

    public List<T> findList(Class<T> entityClass);
}
