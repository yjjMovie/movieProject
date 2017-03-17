package org.movie.action;

import org.movie.entity.Cinema;
import org.movie.entity.Movie;
import org.movie.entity.Showing;
import org.movie.service.ShowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2017/03/13.
 */
@Controller("showingAction")
@Scope("prototype")
public class ShowingAction {

    @Autowired
    private ShowingService service;
    private Showing showing;
    private Movie movie;
    private Cinema cinema;
    private List<Showing> showingList;
    private String message;

    public Showing getShowing() {
        return showing;
    }


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public void setShowing(Showing showing) {
        this.showing = showing;
    }

    public List<Showing> getShowingList() {
        return showingList;
    }

    public void setShowingList(List<Showing> showingList) {
        this.showingList = showingList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String findShowing(){
        showingList = service.findShowing();
        return "findShowing";
    }

    public String findShowingById(){
        showing = service.findShowingById(showing.getShowingId());
        return "findShowingById";
    }

    public String updateShowing() throws Exception {
        Movie m = new Movie();
        m.setMovieId(movie.getMovieId());
        System.out.println(cinema.getCinemaId());
        Cinema c =  service.findCinameById(cinema.getCinemaId());
        c.setMovieHalls(null);
        showing.setMovie(m);
        showing.getCinemas().add(c);
        message = service.update(showing);

        return "updateShowing";
    }

    public String addShowing() throws Exception {

        Movie m = new Movie();
        m.setMovieId(movie.getMovieId());
        System.out.println(cinema.getCinemaId());
        Cinema c =  service.findCinameById(cinema.getCinemaId());
        c.setMovieHalls(null);
        showing.setMovie(m);
        showing.getCinemas().add(c);

        message = service.save(showing);
        return "addShowing";
    }

    public String deleteShowing() throws Exception {
        message = service.remove(showing);

        return "deleteShowing";
    }
}
