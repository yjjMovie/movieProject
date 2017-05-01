package org.movie.action;

import org.movie.entity.Comment;
import org.movie.entity.Movie;
import org.movie.exception.NotFoundException;
import org.movie.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2017/04/10.
 */
@Controller("commentAction")
@Scope("prototype")
public class CommentAction {

    @Autowired
    private CommentService service;
    private List<Comment> commentList;
    private Comment comment;
    private Movie movie;

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String findCommentByMovieId(){
        commentList = service.findCommentByMovieId(movie.getMovieId());
        if(commentList.size() != 0){
            System.out.println(commentList);
            return "findCommentByMovieId";
        }else{
            throw new NotFoundException("此电影还没有评论！");
        }
    }
}
