package org.movie.dao.impl;

import org.movie.dao.AdminDao;
import org.movie.entity.Admin;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

/**
 * Created by Administrator on 2017/03/16.
 */
@Repository("adminDao")
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao {
    @Override
    public Admin findByName(Class<Admin> adminClass, Admin admin) {
        String jpql = "from Admin a where a.adminName = ?1 and a.adminPassword = ?2";
        try{
            Query query = em.createQuery(jpql);
            query.setParameter(1, admin.getAdminName());
            query.setParameter(2,admin.getAdminPassword());
            admin = (Admin) query.getSingleResult();
            return admin;
        }catch (Exception e){
        }
        return null;
    }
}
