package org.movie.service;

import org.movie.dao.BaseDao;
import org.movie.entity.Comment;

import java.util.List;

/**
 * Created by Administrator on 2017/03/13.
 */
public class CommentService {

    BaseDao<Comment> dao = new BaseDao<>();

    public List<Comment> findComment(){

        return dao.findList(Comment.class);
    }

    public Comment findCommentById(String id){

        return dao.findById(Comment.class, id);
    }

    public boolean update(Comment comment){

        return dao.update(comment);
    }
    public boolean save(Comment comment){

        return dao.save(comment);
    }
    public boolean remove(Comment comment){

        return dao.remove(comment);
    }
}
