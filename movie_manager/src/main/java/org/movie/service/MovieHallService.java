package org.movie.service;

import org.movie.dao.MovieHallDao;
import org.movie.entity.MovieHall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/02/07.
 */
@Service
@Transactional
public class MovieHallService {

    @Autowired
    private MovieHallDao dao;
    String message = "";

    public List<MovieHall> findMovieHall() {
        List<MovieHall> list = dao.findList(MovieHall.class);
        return list;
    }

    public List<MovieHall> findHallByCinemaId(String id){

        return dao.findHallByCinemaId(id);
    }
    public MovieHall findMovieHallById(String movieHallId) {
        MovieHall movieHall = dao.findById(MovieHall.class, movieHallId);
        return movieHall;
    }

    public String update(MovieHall movieHall) {
        try{
            dao.update(movieHall);
            message = "更新成功";
        }catch (RuntimeException e){
            message = "更新失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String save(MovieHall movieHall) {

        try{
            dao.save(movieHall);
            message = "添加成功";
        }catch (RuntimeException e){
            message = "添加失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String remove(MovieHall movieHall) {

        try{
            dao.remove(movieHall);
            message = "删除成功";
        }catch (RuntimeException e){
            message = "删除失败，请重新操作！";
            throw e;
        }
        return message;
    }
}
