package org.movie.dao.impl;

import org.movie.dao.AdminDao;
import org.movie.entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/03/16.
 */
@Repository("adminDao")
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao {
}
