package org.movie.service;

import org.movie.dao.BaseDao;
import org.movie.entity.Cinema;
import org.movie.entity.Showing;

import java.util.List;

/**
 * Created by Administrator on 2017/03/13.
 */
public class ShowingService {

    BaseDao<Showing> dao = new BaseDao<>();
    BaseDao<Cinema> cDao = new BaseDao<>();

    public List<Showing> findShowing(){

        return dao.findList(Showing.class);
    }

    public Showing findShowingById(String id){

        return dao.findById(Showing.class, id);
    }


    public boolean update(Showing showing){

        return dao.update(showing);
    }
    public boolean save(Showing showing){

        return dao.save(showing);
    }
    public boolean remove(Showing showing){

        return dao.remove(showing);
    }

    public Cinema findCinameById(String cinemaId) {
        return cDao.findById(Cinema.class, cinemaId);
    }
}
