package org.movie.dao;

import org.movie.entity.CinemaManager;

import java.util.List;

/**
 * Created by Administrator on 2017/04/11.
 */
public interface CinemaManagerDao extends BaseDao<CinemaManager> {

    public CinemaManager findCinemaManager(Class<CinemaManager> cinemaManagerClass, CinemaManager cinemaManager);

    public CinemaManager findCinemaManagerByName(String name);

    public List<CinemaManager> findCinemaManagerByCinemaId(String id);
}
