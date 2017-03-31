package org.movie.dao.impl;

import org.movie.dao.ItemDao;
import org.movie.entity.OrderItem;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/03/30.
 */
@Repository
public class ItemDaoImpl extends BaseDaoImpl<OrderItem> implements ItemDao {

    @Override
    public List<OrderItem> findItemByCondition(String jpql, Map<String, Object> map) {
        Query query = em.createQuery(jpql);
        for (String key : map.keySet()) {
            query.setParameter(key,map.get(key));
        }
        return query.getResultList();
    }
}
