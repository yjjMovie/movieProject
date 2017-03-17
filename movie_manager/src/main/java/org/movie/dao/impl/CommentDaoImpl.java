package org.movie.dao.impl;

import org.movie.dao.CommentDao;
import org.movie.entity.Comment;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/03/16.
 */
@Repository("commentDao")
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentDao {
}
