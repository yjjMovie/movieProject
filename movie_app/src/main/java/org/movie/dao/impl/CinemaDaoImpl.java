package org.movie.dao.impl;

import org.movie.dao.CinemaDao;
import org.movie.entity.Cinema;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Administrator on 2017/04/06.
 */
@Repository("cinemaDao")
public class CinemaDaoImpl extends BaseDaoImpl<Cinema> implements CinemaDao {
    @Override
    public List<Cinema> findCinemaByAreaId(String id) {
        String jpql = "select c from Cinema c join c.area a where a.areaId =?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,id);
        return query.getResultList();
    }
}
