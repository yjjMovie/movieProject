package org.movie.service;

import org.movie.utils.PageBean;


/**
 * Created by Administrator on 2017/03/31.
 */
public interface MovieService {

    public PageBean findMovieByPage(int pageNum);
}
