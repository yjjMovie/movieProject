package org.movie.action;

import org.movie.entity.Cinema;
import org.movie.entity.Movie;
import org.movie.entity.MovieHall;
import org.movie.entity.MovieSession;
import org.movie.exception.NotFoundException;
import org.movie.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/03/17.
 */
@Controller("sessionAction")
@Scope("prototype")
public class SessionAction {

    @Autowired
    private SessionService service;

    private List<MovieSession> sessionList;
    private MovieSession movieSession;

    private Movie movie;
    private MovieHall movieHall;
    private Cinema cinema;
    private String message;

    public List<MovieSession> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<MovieSession> sessionList) {
        this.sessionList = sessionList;
    }

    public MovieSession getMovieSession() {
        return movieSession;
    }

    public void setMovieSession(MovieSession movieSession) {
        this.movieSession = movieSession;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public MovieHall getMovieHall() {
        return movieHall;
    }

    public void setMovieHall(MovieHall movieHall) {
        this.movieHall = movieHall;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String findSessionByCinemaId() throws IOException {
        System.out.println(cinema.getCinemaId());
        sessionList = service.findSessionByCinemaId(cinema.getCinemaId());
        System.out.println(sessionList);
        return "findSession";
    }
    public String findHallByMovieId() throws IOException {
        sessionList = service.findHallByMovieId(movie.getMovieId(),cinema.getCinemaId());
        if(sessionList.size() != 0){
            return "findHallByMovieId";
        }
        System.out.println(sessionList);
        throw new NotFoundException("影院没有此电影的场次!");
    }

    public String findStartById() throws Exception {
        System.out.println(movieHall.getMovieHallId()+"--"+movie.getMovieId()+"--"+cinema.getCinemaId());
        sessionList = service.findStartById(movieHall.getMovieHallId(), cinema.getCinemaId(), movie.getMovieId());
        System.out.println("12345::"+sessionList);
        return "findStartById";
    }

    public String addSession() throws Exception {

        movieSession.setCinema(cinema);
        movieSession.setMovie(movie);
        movieSession.setMovieHall(movieHall);
        message = service.save(movieSession);

        return "addSession";
    }

    public String findSessionById() throws Exception {
        movieSession = service.findMovieSessionById(movieSession.getSessionId());
        return "findSessionById";
    }

    public String updateSession() throws Exception {
        movieSession.setCinema(cinema);
        movieSession.setMovie(movie);
        movieSession.setMovieHall(movieHall);
        message = service.update(movieSession);
        return "updateSession";
    }

    public String deleteSession() throws Exception {
        message = service.remove(movieSession);
        return "deleteSession";
    }


}
