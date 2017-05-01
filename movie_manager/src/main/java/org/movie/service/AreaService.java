package org.movie.service;

import org.movie.dao.AreaDao;
import org.movie.entity.Areas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Areaistrator on 2017/02/13.
 */
@Service
@Transactional
public class AreaService {

    @Autowired
    private AreaDao dao;
    String message = "";

    public List<Areas> findArea() {
        return dao.findList(Areas.class);
    }

    public List<Areas> findAreaByCityId(String id){
        return dao.findAreaByCityId(id);
    }

    public Areas findAreaById(String areaId) {
        return dao.findById(Areas.class, areaId);
    }

    public String update(Areas area) {
        try{
            dao.update(area);
            message = "更新成功";
        }catch (RuntimeException e){
            message = "更新失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String save(Areas area) {

        try{
            dao.save(area);
            message = "添加成功";
        }catch (RuntimeException e){
            message = "添加失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String remove(Areas area) {

        try{
            dao.remove(area);
            message = "删除成功";
        }catch (RuntimeException e){
            message = "删除失败，请重新操作！";
            throw e;
        }
        return message;
    }

}
