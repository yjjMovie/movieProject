package org.movie.service;

import org.movie.dao.MovieDao;
import org.movie.entity.Movie;
import org.movie.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/02/14.
 */
@Service("movieService")
@Transactional
public class MovieService {

    @Autowired
    private MovieDao dao;
    String message = "";

    public PageBean findMovie(int pageNum) {
        System.out.println("pageNum:"+pageNum);
        PageBean pageBean = new PageBean();
        pageBean.setPageNum(pageNum);
        int row = Integer.parseInt(String.valueOf(dao.count()));
        pageBean.setRowCount(row);
        pageBean.setList(dao.findList(pageBean));
        return pageBean;
    }

    public List<Movie> findMovie(){

        return dao.findList(Movie.class);
    }

    public Movie findMovieById(String movieId) {
        return dao.findById(Movie.class, movieId);
    }

    public String updateMovie(Movie movie) {
        dao.update(movie);
        message = "更新成功";
        return message;
    }

    public String saveMovie(Movie movie) {

        dao.save(movie);
        message = "添加成功";
        return message;
    }

    public String removeMovie(Movie movie) {

        try{
            dao.remove(movie);
            message = "删除成功";
        }catch (RuntimeException e){
            message = "删除失败，请重新操作！";
            throw e;
        }
        return message;
    }
}
