package org.movie.dao.impl;

import org.movie.dao.MovieDao;
import org.movie.entity.Movie;
import org.movie.utils.PageBean;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Administrator on 2017/03/31.
 */
@Repository
public class MovieDaoImpl extends BaseDaoImpl<Movie> implements MovieDao {

    @Override
    public List<Movie> findMovieByPage(PageBean pageBean) {
        String jpql = "from Movie m";
        Query query = em.createQuery(jpql);
        query.setFirstResult(pageBean.getFirstResult());
        query.setMaxResults(pageBean.getMaxResult());
        return query.getResultList();
    }

    @Override
    public long count() {
        String jpql = "select count(m) from Movie m";

        return (long) em.createQuery(jpql).getResultList().get(0);
    }
}
