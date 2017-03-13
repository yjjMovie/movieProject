package org.movie.service;

import org.movie.dao.BaseDao;
import org.movie.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/01/13.
 */
public class UserService {

    BaseDao<User> dao = new BaseDao<>();

    public List<User> findUser() {
        List<User> list = dao.findList(User.class);
        return list;
    }

    public User findUserById(String userId) {
        User user = dao.findById(User.class, userId);
        return user;
    }

    public boolean save(User user) {
        return dao.save(user);
    }

    public boolean update(User user) {
        return dao.update(user);
    }

    public boolean remove(User user) {
        return dao.remove(user);
    }
}
