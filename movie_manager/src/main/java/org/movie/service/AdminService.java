package org.movie.service;

import com.opensymphony.xwork2.ActionContext;
import org.movie.dao.AdminDao;
import org.movie.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/01/12.
 */
@Service
@Transactional
public class AdminService {
    
    @Autowired
    private AdminDao dao;
    String message  = "";

    public List<Admin> findAdmin(){
        List<Admin> list = dao.findList(Admin.class);
        return list;
    }

    public Admin findAdminById(String id){
        Admin admin = dao.findById(Admin.class, id);
        return admin;
    }
    public Admin findAdminByName(Admin admin){

        return dao.findByName(Admin.class, admin);
    }

    public String update(Admin admin) {
        try{
            dao.update(admin);
            message = "更新成功";
        }catch (RuntimeException e){
            message = "更新失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String save(Admin admin) {

        try{
            dao.save(admin);
            message = "添加成功";
        }catch (RuntimeException e){
            message = "添加失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String remove(Admin admin) {

        try{
            dao.remove(admin);
            message = "删除成功";
        }catch (RuntimeException e){
            message = "删除失败，请重新操作！";
            throw e;
        }
        return message;
    }
}
