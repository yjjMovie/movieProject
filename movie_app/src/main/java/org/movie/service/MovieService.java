package org.movie.service;

import org.movie.entity.Movie;
import org.movie.utils.PageBean;

import java.util.List;


/**
 * Created by Administrator on 2017/03/31.
 */
public interface MovieService {

    public PageBean findMovieByPage(int pageNum);

    public List<Movie> findMovieByShow();

    public List<Movie> findMovieByPresell();

    public Movie findMovieById(String id);
}
