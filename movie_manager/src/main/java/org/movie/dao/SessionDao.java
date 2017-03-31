package org.movie.dao;

import org.movie.entity.MovieSession;

import java.util.List;

/**
 * Created by Administrator on 2017/03/16.
 */
public interface SessionDao extends BaseDao<MovieSession> {
    public List<MovieSession> findSessionByCinemaId(String cinemaId);

    public List<MovieSession> findHallByMovieId(String movieId, String cinemaId);

    public List<MovieSession> findStartById(String movieHallId, String cinemaId, String movieId);
}
