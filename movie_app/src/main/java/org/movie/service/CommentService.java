package org.movie.service;

import org.movie.entity.Comment;

import java.util.List;

/**
 * Created by Administrator on 2017/04/10.
 */
public interface CommentService {

    public List<Comment> findCommentByMovieId(String id);
}
