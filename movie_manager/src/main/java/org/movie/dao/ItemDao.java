package org.movie.dao;

import org.movie.entity.OrderItem;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/03/30.
 */
public interface ItemDao extends BaseDao<OrderItem> {

    public List<OrderItem> findItemByCondition(String jpql, Map<String, Object> map);
}
