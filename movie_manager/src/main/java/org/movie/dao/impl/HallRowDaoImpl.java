package org.movie.dao.impl;

import org.movie.dao.HallRowDao;
import org.movie.entity.HallRow;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Administrator on 2017/04/19.
 */
@Repository("hallRowDao")
public class HallRowDaoImpl extends BaseDaoImpl<HallRow> implements HallRowDao {
    @Override
    public List<HallRow> findRowByHallId(String id) {
        String jpql = "from HallRow r where r.movieHall.movieHallId = ?1 order by r.hallRowName";
        Query query = em.createQuery(jpql);
        query.setParameter(1, id);
        return query.getResultList();
    }
}
