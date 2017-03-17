package org.movie.action;

import org.movie.entity.Comment;
import org.movie.entity.Movie;
import org.movie.entity.User;
import org.movie.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/03/13.
 */
@Controller("commentAction")
@Scope("prototype")
public class CommentAction {

    private List<Comment> commentList;
    private Comment comment;
    private User user;
    private Movie movie;
    private String message;
    @Autowired
    private CommentService service;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String findComment(){
        List<Comment> list = service.findComment();
        commentList = list;
        return "findComment";
    }

    public String findCommentById(){

        comment = service.findCommentById(comment.getCommentId());
        return "findCommentById";
    }
    public String updateComment() throws Exception {
        User u = new User();
        u.setUserId(user.getUserId());
        Movie m = new Movie();
        m.setMovieId(movie.getMovieId());
        comment.setUser(u);
        comment.setMovie(m);
        message = service.update(comment);

        return "updateComment";
    }

    public String addComment() throws Exception {
        User u = new User();
        u.setUserId(user.getUserId());
        Movie m = new Movie();
        m.setMovieId(movie.getMovieId());
        comment.setCommentTime(new Date(System.currentTimeMillis()));
        comment.setUser(u);
        comment.setMovie(m);
        message = service.save(comment);

        return "addComment";
    }

    public String deleteComment() throws Exception {
        message = service.remove(comment);

        return "deleteComment";
    }
}
