package org.movie.dao.impl;

import org.movie.dao.MovieTypeDao;
import org.movie.entity.MovieType;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/03/16.
 */
@Repository("movieTypeDao")
public class MovieTypeDaoImpl extends BaseDaoImpl<MovieType> implements MovieTypeDao {

}
