package org.movie.service;

import org.movie.dao.SessionDao;
import org.movie.entity.MovieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MovieSessionistrator on 2017/01/12.
 */
@Service
@Transactional
public class SessionService {
    
    @Autowired
    private SessionDao dao;
    String message  = "";

    public List<MovieSession> findSessionByCinemaId(String cid){
        List<MovieSession> list = dao.findSessionByCinemaId(cid);
        return list;
    }

    public MovieSession findMovieSessionById(String id){
        MovieSession session = dao.findById(MovieSession.class, id);
        return session;
    }

    public String update(MovieSession movieSession) {
        try{
            dao.update(movieSession);
            message = "更新成功";
        }catch (RuntimeException e){
            message = "更新失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String save(MovieSession movieSession) {

        try{
            dao.save(movieSession);
            message = "添加成功";
        }catch (RuntimeException e){
            message = "添加失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String remove(MovieSession movieSession) {

        try{
            dao.remove(movieSession);
            message = "删除成功";
        }catch (RuntimeException e){
            message = "删除失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public List<MovieSession> findHallByMovieId(String movieId,String cinemaId) {

        return dao.findHallByMovieId(movieId,cinemaId);
    }

    public List<MovieSession> findStartById(String movieHallId, String cinemaId, String movieId) {
        return dao.findStartById(movieHallId,cinemaId,movieId);
    }
}
