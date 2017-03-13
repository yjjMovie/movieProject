package org.movie.service;

import org.movie.dao.BaseDao;
import org.movie.entity.MovieType;

import java.util.List;

/**
 * Created by Administrator on 2017/02/09.
 */
public class MovieTypeService {

    BaseDao<MovieType> dao = new BaseDao<>();

    public List<MovieType> findMovieType() {
        List<MovieType> list = dao.findList(MovieType.class);
        /*for (MovieType type : list) {
            type.setMovie(null);
        }*/
        return list;
    }

    public MovieType findMovieTypeById(String movieTypeId) {
        MovieType type = dao.findById(MovieType.class, movieTypeId);
        //type.setMovie(null);
        return type;

    }

    public boolean update(MovieType type) {
        return dao.update(type);
    }

    public boolean save(MovieType type) {
        return dao.save(type);
    }

    public boolean remove(MovieType type) {
        return dao.remove(type);
    }
}
