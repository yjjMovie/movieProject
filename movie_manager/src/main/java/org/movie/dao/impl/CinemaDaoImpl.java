package org.movie.dao.impl;

import org.movie.dao.CinemaDao;
import org.movie.entity.Cinema;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/03/16.
 */
@Repository("cinemaDao")
public class CinemaDaoImpl extends BaseDaoImpl<Cinema> implements CinemaDao {
}
