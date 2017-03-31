package org.movie.dao;

import org.movie.entity.Movie;
import org.movie.entity.Showing;

import java.util.List;

/**
 * Created by Administrator on 2017/03/16.
 */
public interface ShowingDao extends BaseDao<Showing> {

    public List<Showing> findHallByCinemaId(String id);
}
