package org.movie.service.impl;

import org.movie.dao.CommentDao;
import org.movie.entity.Comment;
import org.movie.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/04/10.
 */
@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao dao;
    @Override
    public List<Comment> findCommentByMovieId(String id) {
        return dao.findCommentByMovieId(id);
    }
}
