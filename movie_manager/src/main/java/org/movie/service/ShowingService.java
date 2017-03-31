package org.movie.service;

import org.movie.dao.CinemaDao;
import org.movie.dao.ShowingDao;
import org.movie.entity.Cinema;
import org.movie.entity.Showing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/03/13.
 */

@Service
@Transactional
public class ShowingService {
    @Autowired
    private ShowingDao dao;
    @Autowired
    private CinemaDao cDao;
    String message = "";

    public List<Showing> findShowing(){

        return dao.findList(Showing.class);
    }
    public List<Showing> findShowingByCinemaId(String id){

        return dao.findHallByCinemaId(id);
    }

    public Showing findShowingById(String id){

        return dao.findById(Showing.class, id);
    }

    public String update(Showing showing) {
        try{
            dao.update(showing);
            message = "更新成功";
        }catch (RuntimeException e){
            message = "更新失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String save(Showing showing) {

        try{
            dao.save(showing);
            message = "添加成功";
        }catch (RuntimeException e){
            message = "添加失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String remove(Showing showing) {

        try{
            dao.remove(showing);
            message = "删除成功";
        }catch (RuntimeException e){
            message = "删除失败，请重新操作！";
            throw e;
        }
        return message;
    }
    public Cinema findCinameById(String cinemaId) {
        return cDao.findById(Cinema.class, cinemaId);
    }
}
