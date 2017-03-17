package org.movie.dao;

import org.movie.entity.Movie;
import org.movie.utils.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/03/16.
 */
public interface MovieDao extends BaseDao<Movie> {

    public List<Movie> findList(PageBean pageBean);

    public Long count();
}
