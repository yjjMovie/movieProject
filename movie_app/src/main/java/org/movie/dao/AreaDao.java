package org.movie.dao;

import org.movie.entity.Areas;

import java.util.List;

/**
 * Created by Administrator on 2017/04/05.
 */
public interface AreaDao extends BaseDao<Areas> {

    public List<Areas> findAreaByCityId(String id);
}
