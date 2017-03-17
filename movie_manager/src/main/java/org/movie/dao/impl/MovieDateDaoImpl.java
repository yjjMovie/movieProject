package org.movie.dao.impl;

import org.movie.dao.MovieDateDao;
import org.movie.entity.MovieDate;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/03/16.
 */
@Repository("movieDateDao")
public class MovieDateDaoImpl extends BaseDaoImpl<MovieDate> implements MovieDateDao {

}
