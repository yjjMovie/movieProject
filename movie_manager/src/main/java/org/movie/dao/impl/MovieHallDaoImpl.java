package org.movie.dao.impl;

import org.movie.dao.MovieHallDao;
import org.movie.entity.MovieHall;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Administrator on 2017/03/16.
 */
@Repository("movieHallDao")
public class MovieHallDaoImpl extends BaseDaoImpl<MovieHall> implements MovieHallDao {
    @Override
    public List<MovieHall> findHallByCinemaId(String id) {
        String jpql = "from MovieHall m where m.cinema.cinemaId =?1 order by m.movieHallName";
        Query query = em.createQuery(jpql);
        query.setParameter(1,id);
        return query.getResultList();
    }

}
