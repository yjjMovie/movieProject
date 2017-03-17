package org.movie.dao.impl;

import org.movie.dao.MovieDao;
import org.movie.entity.Movie;
import org.movie.utils.PageBean;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;


/**
 * Created by Administrator on 2017/03/16.
 */
@Repository("movieDao")
public class MovieDaoImpl extends BaseDaoImpl<Movie> implements MovieDao {

    @Override
    public List<Movie> findList(PageBean pageBean) {
        String jpql = "from Movie m";
        Query query = em.createQuery(jpql);
        query.setFirstResult(pageBean.getFirstResult());
        query.setMaxResults(pageBean.getMaxResult());
        List<Movie> list = query.getResultList();
        return list;
    }

    @Override
    public List<Movie> findList() {
        String jpql = "from Movie m";
        return em.createQuery(jpql).getResultList();
    }

    @Override
    public Long count() {
        String jpql = "select count(m) from Movie m";
        return (Long) em.createQuery(jpql).getResultList().get(0);
    }

}
