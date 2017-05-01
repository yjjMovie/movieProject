package org.movie.service.impl;

import org.movie.dao.AreaDao;
import org.movie.entity.Areas;
import org.movie.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/04/05.
 */
@Service
@Transactional
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao dao;
    @Override
    public List<Areas> findAreaByCityId(String id) {
        return dao.findAreaByCityId(id);
    }
}
