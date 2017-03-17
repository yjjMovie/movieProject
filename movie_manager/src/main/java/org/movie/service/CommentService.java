package org.movie.service;

import org.movie.dao.CommentDao;
import org.movie.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Commentistrator on 2017/03/13.
 */

@Service
@Transactional
public class CommentService {

    @Autowired
    private CommentDao dao;
    String message = "";

    public List<Comment> findComment(){

        return dao.findList(Comment.class);
    }

    public Comment findCommentById(String id){

        return dao.findById(Comment.class, id);
    }

    public String update(Comment comment) {
        try{
            dao.update(comment);
            message = "更新成功";
        }catch (RuntimeException e){
            message = "更新失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String save(Comment comment) {

        try{
            dao.save(comment);
            message = "添加成功";
        }catch (RuntimeException e){
            message = "添加失败，请重新操作！";
            throw e;
        }
        return message;
    }

    public String remove(Comment comment) {

        try{
            dao.remove(comment);
            message = "删除成功";
        }catch (RuntimeException e){
            message = "删除失败，请重新操作！";
            throw e;
        }
        return message;
    }
}
