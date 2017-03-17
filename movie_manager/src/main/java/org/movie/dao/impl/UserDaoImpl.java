package org.movie.dao.impl;

import org.movie.dao.UserDao;
import org.movie.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/03/16.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
}
