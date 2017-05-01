package org.movie.action;

import org.movie.entity.Movie;
import org.movie.service.MovieService;
import org.movie.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2017/03/31.
 */
@Controller("movieAction")
public class MovieAction {

    @Autowired
    private MovieService service;
    private Movie movie;
    private List<Movie> movieList;
    private int pageNum;
    private PageBean pageBean;

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String findMovieByPage(){
        pageBean = service.findMovieByPage(pageNum);
        return "findMovieByPage";
    }

    public String findMovieByShow(){
        movieList = service.findMovieByShow();
        return "findMovieByShow";
    }

    public String findMovieByPresell(){
        movieList = service.findMovieByPresell();
        return "findMovieByPresell";
    }

    public String findMovieById(){
        movie = service.findMovieById(movie.getMovieId());
        return "findMovieById";
    }

}
