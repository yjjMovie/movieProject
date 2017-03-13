package org.movie.service;

import org.movie.dao.BaseDao;
import org.movie.entity.Cinema;

import java.util.List;

/**
 * Created by Administrator on 2017/02/06.
 */
public class CinemaService {

    BaseDao<Cinema> dao = new BaseDao<>();

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

    public boolean update(Cinema cinema){
        return dao.update(cinema);
    }

    public boolean save(Cinema cinema){
        return dao.save(cinema);
    }

    public boolean remove(Cinema cinema){
        return dao.remove(cinema);
    }
}
