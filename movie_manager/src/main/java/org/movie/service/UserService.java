package org.movie.service;

import org.movie.dao.UserDao;
import org.movie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Useristrator on 2017/01/13.
 */

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao dao;
    String message = "";

    public List<User> findUser() {
        List<User> list = dao.findList(User.class);
        return list;
    }

    public User findUserById(String userId) {
        User user = dao.findById(User.class, userId);
        return user;
    }

    public String update(User user) {
        try{
            dao.update(user);
            message = "更新成功";
        }catch (RuntimeException e){
            message = "更新失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String save(User user) {

        try{
            dao.save(user);
            message = "添加成功";
        }catch (RuntimeException e){
            message = "添加失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String remove(User user) {

        try{
            dao.remove(user);
            message = "删除成功";
        }catch (RuntimeException e){
            message = "删除失败，请重新操作！";
            throw e;
        }
        return message;
    }
}
