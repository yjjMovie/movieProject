package org.movie.dao;

import org.movie.entity.HallRow;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/04/19.
 */
public interface HallRowDao extends BaseDao<HallRow> {

    public List<HallRow> findRowByHallId(String id);
}
