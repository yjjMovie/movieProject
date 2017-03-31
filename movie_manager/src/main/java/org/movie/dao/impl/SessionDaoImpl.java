package org.movie.dao.impl;

import org.movie.dao.SessionDao;
import org.movie.entity.MovieSession;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Administrator on 2017/03/16.
 */
@Repository("sessionDao")
public class SessionDaoImpl extends BaseDaoImpl<MovieSession> implements SessionDao {


    @Override
    public List<MovieSession> findSessionByCinemaId(String cinemaId) {
        String jpql = "from MovieSession s where  s.cinema.cinemaId = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,cinemaId);
        return query.getResultList();
    }

    @Override
    public List<MovieSession> findHallByMovieId(String movieId, String cinemaId) {
        String jpql = "select s.movieHall from MovieSession s join s.movie m join s.cinema c where m.movieId =?1 and c.cinemaId = ?2";
        Query query = em.createQuery(jpql);
        query.setParameter(1, movieId);
        query.setParameter(2,cinemaId);
        return query.getResultList();
    }

    @Override
    public List<MovieSession> findStartById(String movieHallId, String cinemaId, String movieId) {
        String jpql = "select s from MovieSession s join s.movie m join s.cinema c join s.movieHall h where m.movieId =?1 and c.cinemaId = ?2 and h.movieHallId = ?3";
        Query query = em.createQuery(jpql);
        query.setParameter(1, movieId);
        query.setParameter(2,cinemaId);
        query.setParameter(3,movieHallId);
        return query.getResultList();
    }

}
