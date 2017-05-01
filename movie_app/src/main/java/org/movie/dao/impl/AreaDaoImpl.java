package org.movie.dao.impl;

import org.movie.dao.AreaDao;
import org.movie.entity.Areas;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Administrator on 2017/04/05.
 */
@Repository("areaDao")
public class AreaDaoImpl extends BaseDaoImpl<Areas> implements AreaDao {

    @Override
    public List<Areas> findAreaByCityId(String id) {
        String jpql = "select a from Areas a join a.city c where c.cityId =?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,id);
        return query.getResultList();
    }
}
