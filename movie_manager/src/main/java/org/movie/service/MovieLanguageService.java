package org.movie.service;

import org.movie.dao.MovieLanguageDao;
import org.movie.entity.MovieLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/02/14.
 */

@Service
@Transactional
public class MovieLanguageService {

    @Autowired
    private MovieLanguageDao dao;
    String message = "";

    public List<MovieLanguage> findMovieLanguage() {
        List<MovieLanguage> list = dao.findList(MovieLanguage.class);
        return list;
    }

    public MovieLanguage findMovieLanguageById(String movieLanguageId) {
        MovieLanguage language  = dao.findById(MovieLanguage.class, movieLanguageId);
        return language;
    }

    public String update(MovieLanguage movieLanguage) {
        try{
            dao.update(movieLanguage);
            message = "更新成功";
        }catch (RuntimeException e){
            message = "更新失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String save(MovieLanguage movieLanguage) {

        try{
            dao.save(movieLanguage);
            message = "添加成功";
        }catch (RuntimeException e){
            message = "添加失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String remove(MovieLanguage movieLanguage) {

        try{
            dao.remove(movieLanguage);
            message = "删除成功";
        }catch (RuntimeException e){
            message = "删除失败，请重新操作！";
            throw e;
        }
        return message;
    }
}
