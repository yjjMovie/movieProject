package org.movie.service;

import org.movie.dao.MovieTypeDao;
import org.movie.entity.MovieType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/02/09.
 */
@Service
@Transactional
public class MovieTypeService {

    @Autowired
    private MovieTypeDao dao;
    String message = "";

    public List<MovieType> findMovieType() {
        List<MovieType> list = dao.findList(MovieType.class);
        return list;
    }

    public MovieType findMovieTypeById(String movieTypeId) {
        MovieType type = dao.findById(MovieType.class, movieTypeId);
        return type;

    }

    public String update(MovieType movieType) {
        try{
            dao.update(movieType);
            message = "更新成功";
        }catch (RuntimeException e){
            message = "更新失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String save(MovieType movieType) {

        try{
            dao.save(movieType);
            message = "添加成功";
        }catch (RuntimeException e){
            message = "添加失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String remove(MovieType movieType) {

        try{
            dao.remove(movieType);
            message = "删除成功";
        }catch (RuntimeException e){
            message = "删除失败，请重新操作！";
            throw e;
        }
        return message;
    }

}
