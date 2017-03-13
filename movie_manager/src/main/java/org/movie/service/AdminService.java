package org.movie.service;

import org.movie.dao.BaseDao;
import org.movie.entity.Admin;

import java.util.List;

/**
 * Created by Administrator on 2017/01/12.
 */
public class AdminService {
    BaseDao<Admin> dao = new BaseDao<>();

    public List<Admin> findAdmin(){
        List<Admin> list = dao.findList(Admin.class);
        return list;
    }

    public Admin findAdminById(String id){
        Admin admin = dao.findById(Admin.class, id);
        return admin;
    }

    public boolean save(Admin admin) {
        return dao.save(admin);
    }

    public boolean update(Admin admin) {
        return dao.update(admin);
    }

    public boolean remove(Admin admin) {
        return dao.remove(admin);
    }
}
