package org.movie.service.impl;

import org.movie.dao.CityDao;
import org.movie.entity.City;
import org.movie.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/04/05.
 */
@Service
@Transactional
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao dao;

    @Override
    public List<City> findCity() {
        return dao.findList(City.class);
    }
}
