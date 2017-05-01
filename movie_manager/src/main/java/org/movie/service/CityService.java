package org.movie.service;

import org.movie.dao.CityDao;
import org.movie.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Cityistrator on 2017/02/13.
 */
@Service
@Transactional
public class CityService {

    @Autowired
    private CityDao dao;
    String message = "";

    public List<City> findCity() {
        return dao.findList(City.class);
    }

    public City findCityById(String cityId) {
        return dao.findById(City.class, cityId);
    }

    public String update(City city) {
        try{
            dao.update(city);
            message = "更新成功";
        }catch (RuntimeException e){
            message = "更新失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String save(City city) {

        try{
            dao.save(city);
            message = "添加成功";
        }catch (RuntimeException e){
            message = "添加失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String remove(City city) {

        try{
            dao.remove(city);
            message = "删除成功";
        }catch (RuntimeException e){
            message = "删除失败，请重新操作！";
            throw e;
        }
        return message;
    }

}
