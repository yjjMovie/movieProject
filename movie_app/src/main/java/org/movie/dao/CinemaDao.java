package org.movie.dao;

import org.movie.entity.Cinema;

import java.util.List;

/**
 * Created by Administrator on 2017/04/06.
 */
public interface CinemaDao extends BaseDao<Cinema> {

    public List<Cinema> findCinemaByAreaId(String id);
}
