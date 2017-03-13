package org.movie.service;

import org.movie.dao.BaseDao;
import org.movie.entity.MovieArea;

import java.util.List;

/**
 * Created by Administrator on 2017/02/13.
 */
public class MovieAreaService {

    BaseDao<MovieArea> dao = new BaseDao<>();

    public List<MovieArea> findMovieArea() {
        return dao.findList(MovieArea.class);
    }

    public MovieArea findMovieAreaById(String movieAreaId) {
        return dao.findById(MovieArea.class, movieAreaId);
    }

    public boolean update(MovieArea area) {
        return dao.update(area);
    }

    public boolean save(MovieArea area) {
        return dao.save(area);
    }

    public boolean remove(MovieArea area) {
        return dao.remove(area);
    }

}
