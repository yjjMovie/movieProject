package org.movie.dao;

import org.movie.entity.Comment;

import java.util.List;

/**
 * Created by Administrator on 2017/04/10.
 */
public interface CommentDao extends BaseDao<Comment> {

    public List<Comment> findCommentByMovieId(String id);
}
