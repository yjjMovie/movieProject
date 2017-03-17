package org.movie.service;

import org.movie.dao.MovieAreaDao;
import org.movie.entity.MovieArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MovieAreaistrator on 2017/02/13.
 */
@Service
@Transactional
public class MovieAreaService {

    @Autowired
    private MovieAreaDao dao;
    String message = "";

    public List<MovieArea> findMovieArea() {
        return dao.findList(MovieArea.class);
    }

    public MovieArea findMovieAreaById(String movieAreaId) {
        return dao.findById(MovieArea.class, movieAreaId);
    }

    public String update(MovieArea movieArea) {
        try{
            dao.update(movieArea);
            message = "更新成功";
        }catch (RuntimeException e){
            message = "更新失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String save(MovieArea movieArea) {

        try{
            dao.save(movieArea);
            message = "添加成功";
        }catch (RuntimeException e){
            message = "添加失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String remove(MovieArea movieArea) {

        try{
            dao.remove(movieArea);
            message = "删除成功";
        }catch (RuntimeException e){
            message = "删除失败，请重新操作！";
            throw e;
        }
        return message;
    }

}
