package org.movie.service;

import org.movie.entity.Areas;

import java.util.List;

/**
 * Created by Administrator on 2017/04/05.
 */
public interface AreaService {

    public List<Areas> findAreaByCityId(String id);
}
