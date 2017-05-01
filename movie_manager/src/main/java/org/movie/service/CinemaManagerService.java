package org.movie.service;

import org.movie.dao.CinemaManagerDao;
import org.movie.entity.CinemaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/04/11.
 */
@Service
@Transactional
public class CinemaManagerService {
    
    @Autowired
    private CinemaManagerDao dao;
    String message = "";

    public List<CinemaManager> findCinemaManager() {
        List<CinemaManager> list = dao.findList(CinemaManager.class);
        return list;
    }

    public CinemaManager findCinemaManagerById(String cinemaManagerId) {
        CinemaManager cinemaManager = dao.findById(CinemaManager.class, cinemaManagerId);
        return cinemaManager;
    }

    public List<CinemaManager> findCinemaManagerByCinemaId(String cid){

        return dao.findCinemaManagerByCinemaId(cid);
    }

    public CinemaManager findCinemaManagerByName(CinemaManager cinemaManager){
        return dao.findCinemaManager(CinemaManager.class, cinemaManager);
    }

    public CinemaManager findCinemaManagerByName(String name){
        return dao.findCinemaManagerByName(name);
    }



    public String update(CinemaManager cinemaManager) {
        try{
            dao.update(cinemaManager);
            message = "更新成功";
        }catch (RuntimeException e){
            message = "更新失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String save(CinemaManager cinemaManager) {

        try{
            dao.save(cinemaManager);
            message = "添加成功";
        }catch (RuntimeException e){
            message = "添加失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String remove(CinemaManager cinemaManager) {

        try{
            dao.remove(cinemaManager);
            message = "删除成功";
        }catch (RuntimeException e){
            message = "删除失败，请重新操作！";
            throw e;
        }
        return message;
    }
}
