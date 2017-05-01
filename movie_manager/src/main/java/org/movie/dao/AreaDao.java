package org.movie.dao;

import org.movie.entity.Areas;

import java.util.List;

/**
 * Created by Administrator on 2017/03/16.
 */
public interface AreaDao extends BaseDao<Areas> {

    public List<Areas> findAreaByCityId(String id);
}
