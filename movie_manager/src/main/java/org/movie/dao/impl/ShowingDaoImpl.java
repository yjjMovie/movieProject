package org.movie.dao.impl;

import org.movie.dao.ShowingDao;
import org.movie.entity.Movie;
import org.movie.entity.Showing;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Administrator on 2017/03/16.
 */
@Repository("showingDao")
public class ShowingDaoImpl extends BaseDaoImpl<Showing> implements ShowingDao {

    @Override
    public List<Showing> findHallByCinemaId(String id) {
        String jpql = "select s.movie from Showing s join s.cinemas m where m.cinemaId =?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,id);
        return query.getResultList();
    }
}
