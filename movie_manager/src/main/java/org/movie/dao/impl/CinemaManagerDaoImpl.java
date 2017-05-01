package org.movie.dao.impl;

import org.movie.dao.CinemaManagerDao;
import org.movie.entity.CinemaManager;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Administrator on 2017/04/11.
 */
@Repository("cinemaManagerDao")
public class CinemaManagerDaoImpl extends BaseDaoImpl<CinemaManager> implements CinemaManagerDao {
    @Override
    public CinemaManager findCinemaManager(Class<CinemaManager> cinemaManagerClass, CinemaManager cinemaManager) {
        String jpql = "from CinemaManager cm where cm.cinemaManagerName = ?1 and cm.cinemaManagerPwd = ?2";
        try{
            Query query = em.createQuery(jpql);
            query.setParameter(1, cinemaManager.getCinemaManagerName());
            query.setParameter(2, cinemaManager.getCinemaManagerPwd());
            cinemaManager = (CinemaManager) query.getSingleResult();
            return cinemaManager;
        }catch (Exception e){
        }
        return null;
    }

    @Override
    public CinemaManager findCinemaManagerByName(String name) {
        String jpql = "from CinemaManager cm where cm.cinemaManagerName = ?1";
        try{
            Query query = em.createQuery(jpql);
            query.setParameter(1, name);
            return (CinemaManager) query.getSingleResult();
        }catch (Exception e){
        }
        return null;
    }

    @Override
    public List<CinemaManager> findCinemaManagerByCinemaId(String id) {
        String jpql = "from CinemaManager cm where cm.cinema.cinemaId = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, id);
        return query.getResultList();
    }
}
