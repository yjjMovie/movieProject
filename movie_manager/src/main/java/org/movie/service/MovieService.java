package org.movie.service;

import org.movie.dao.BaseDao;
import org.movie.entity.Movie;
import org.movie.entity.MovieLanguage;
import org.movie.entity.MovieType;

import java.util.List;

/**
 * Created by Administrator on 2017/02/14.
 */
public class MovieService {

    BaseDao<Movie> dao = new BaseDao<>();

    public List<Movie> findMovie() {
        List<Movie> list = dao.findList(Movie.class);
        for (Movie movie : list) {
            System.out.println(movie);
        }
        return list;
    }

    public Movie findMovieById(String movieId) {
        Movie movie = dao.findById(Movie.class, movieId);
        return movie;
    }

    public boolean updateMovie(Movie movie) {
        return dao.update(movie);
    }

    public boolean saveMovie(Movie movie) {
        return dao.save(movie);
    }

    public boolean removeMovie(Movie movie) {
        return dao.remove(movie);
    }
}
