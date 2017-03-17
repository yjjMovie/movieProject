package org.movie.service;

import org.movie.dao.MovieDateDao;
import org.movie.entity.MovieDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/02/13.
 */
@Service
@Transactional
public class MovieDateService {

    @Autowired
    private MovieDateDao dao;
    String message = "";

    public List<MovieDate> findMovieDate() {
        return dao.findList(MovieDate.class);
    }

    public MovieDate findMovieDateById(String movieDateId) {
        return dao.findById(MovieDate.class, movieDateId);
    }


    public String update(MovieDate movieDate) {
        try{
            dao.update(movieDate);
            message = "更新成功";
        }catch (RuntimeException e){
            message = "更新失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String save(MovieDate movieDate) {

        try{
            dao.save(movieDate);
            message = "添加成功";
        }catch (RuntimeException e){
            message = "添加失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String remove(MovieDate movieDate) {

        try{
            dao.remove(movieDate);
            message = "删除成功";
        }catch (RuntimeException e){
            message = "删除失败，请重新操作！";
            throw e;
        }
        return message;
    }
}
