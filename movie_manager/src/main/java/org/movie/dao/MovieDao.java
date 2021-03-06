package org.movie.dao;

import org.movie.entity.Movie;
import org.movie.utils.PageBean;

import java.util.List;

/**
 * Created by Administrator on 2017/03/16.
 */
public interface MovieDao extends BaseDao<Movie> {

    public List<Movie> findList(PageBean pageBean);

    public List<Movie> findList();

    public Long count();
}
