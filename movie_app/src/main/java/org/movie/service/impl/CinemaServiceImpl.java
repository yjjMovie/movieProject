package org.movie.service.impl;

import org.movie.dao.CinemaDao;
import org.movie.entity.Cinema;
import org.movie.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/04/06.
 */
@Service
@Transactional
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaDao dao;

    @Override
    public List<Cinema> findCinemaByAreaId(String id) {
        return dao.findCinemaByAreaId(id);
    }
}
