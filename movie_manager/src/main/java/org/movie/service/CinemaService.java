package org.movie.service;

import org.movie.dao.CinemaDao;
import org.movie.entity.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/02/06.
 */
@Service
@Transactional
public class CinemaService {

    @Autowired
    private CinemaDao dao;
    String message = "";

    public List<Cinema> findCinema() {
        List<Cinema> list = dao.findList(Cinema.class);
        for (Cinema cinema : list) {
            cinema.setMovieHalls(null);
        }
        return list;
    }

    public Cinema findCinemaById(String cinemaId) {
        Cinema cinema = dao.findById(Cinema.class, cinemaId);
        cinema.setMovieHalls(null);
        return cinema;
    }

    public String update(Cinema cinema) {
        try{
            dao.update(cinema);
            message = "更新成功";
        }catch (RuntimeException e){
            message = "更新失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String save(Cinema cinema) {

        try{
            dao.save(cinema);
            message = "添加成功";
        }catch (RuntimeException e){
            message = "添加失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String remove(Cinema cinema) {

        try{
            dao.remove(cinema);
            message = "删除成功";
        }catch (RuntimeException e){
            message = "删除失败，请重新操作！";
            throw e;
        }
        return message;
    }
}
