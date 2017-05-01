package org.movie.service;

import org.movie.dao.HallRowDao;
import org.movie.entity.HallRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/04/19.
 */
@Service
@Transactional
public class HallRowService {

    @Autowired
    private HallRowDao dao;
    String message = "";

    public List<HallRow> findRowByHallId(String id){
        return dao.findRowByHallId(id);
    }

    public String save(HallRow hallRow){
        try{
            dao.save(hallRow);
            message = "添加成功";
        }catch (RuntimeException e){
            message = "添加失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String update(HallRow hallRow) {
        try{
            dao.update(hallRow);
            message = "更新成功";
        }catch (RuntimeException e){
            message = "更新失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String remove(HallRow hallRow) {
        try{
            dao.remove(hallRow);
            message = "删除成功";
        }catch (RuntimeException e){
            message = "删除失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public HallRow findRowById(String hallRowId) {
        return dao.findById(HallRow.class, hallRowId);
    }
}
