package org.movie.service;

import org.movie.dao.BaseDao;
import org.movie.entity.MovieDate;

import java.util.List;

/**
 * Created by Administrator on 2017/02/13.
 */
public class MovieDateService {

    BaseDao<MovieDate> dao = new BaseDao<>();

    public List<MovieDate> findMovieDate() {
        return dao.findList(MovieDate.class);
    }

    public MovieDate findMovieDateById(String movieDateId) {
        return dao.findById(MovieDate.class, movieDateId);
    }

    public boolean update(MovieDate date) {
        return dao.update(date);
    }

    public boolean save(MovieDate date) {
        return dao.save(date);
    }

    public boolean remove(MovieDate date) {
        return dao.remove(date);
    }
}
