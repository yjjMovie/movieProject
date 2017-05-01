package org.movie.dao;

import org.movie.entity.Movie;
import org.movie.utils.PageBean;

import java.util.List;

/**
 * Created by Administrator on 2017/03/31.
 */
public interface MovieDao extends BaseDao<Movie> {

    public List<Movie> findMovieByPage(PageBean pageBean);

    public List<Movie> findMovieByShow();

    public List<Movie> findMovieByPresell();

    public long count();
}
