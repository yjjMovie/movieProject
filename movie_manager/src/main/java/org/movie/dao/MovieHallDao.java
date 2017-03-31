package org.movie.dao;

import org.movie.entity.MovieHall;

import java.util.List;

/**
 * Created by Administrator on 2017/03/16.
 */
public interface MovieHallDao extends BaseDao<MovieHall> {

    public List<MovieHall> findHallByCinemaId(String id);
}
