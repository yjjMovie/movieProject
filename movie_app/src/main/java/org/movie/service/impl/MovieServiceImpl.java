package org.movie.service.impl;

import org.movie.dao.MovieDao;
import org.movie.service.MovieService;
import org.movie.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/03/31.
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao dao;

    @Override
    public PageBean findMovieByPage(int pageNum) {
        System.out.println(pageNum);
        PageBean pageBean = new PageBean();
        pageBean.setPageNum(pageNum);
        int row = Integer.parseInt(String.valueOf(dao.count()));
        pageBean.setRowCount(row);
        pageBean.setList(dao.findMovieByPage(pageBean));
        return pageBean;
    }
}
