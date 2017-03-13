package org.movie.service;

import org.movie.dao.BaseDao;
import org.movie.entity.MovieHall;

import java.util.List;

/**
 * Created by Administrator on 2017/02/07.
 */
public class MovieHallService {
    
    BaseDao<MovieHall> dao = new BaseDao<>();

    public List<MovieHall> findMovieHall() {
        List<MovieHall> list = dao.findList(MovieHall.class);
        for (MovieHall hall : list) {
            hall.getCinema().setMovieHalls(null);
        }
        return list;
    }

    public MovieHall findMovieHallById(String movieHallId) {
        MovieHall movieHall = dao.findById(MovieHall.class, movieHallId);
        movieHall.getCinema().setMovieHalls(null);
        return movieHall;
    }

    public boolean update(MovieHall movieHall){
        return dao.update(movieHall);
    }

    public boolean save(MovieHall movieHall){
        return dao.save(movieHall);
    }

    public boolean remove(MovieHall movieHall){
        return dao.remove(movieHall);
    }
}
