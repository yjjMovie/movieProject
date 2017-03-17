package org.movie.dao.impl;

import org.movie.dao.ShowingDao;
import org.movie.entity.Showing;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/03/16.
 */
@Repository("showingDao")
public class ShowingDaoImpl extends BaseDaoImpl<Showing> implements ShowingDao {
}
