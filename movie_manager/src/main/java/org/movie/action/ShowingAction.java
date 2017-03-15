package org.movie.action;

import org.movie.entity.Cinema;
import org.movie.entity.Movie;
import org.movie.entity.Showing;
import org.movie.entity.User;
import org.movie.service.ShowingService;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/03/13.
 */
public class ShowingAction {

    ShowingService service = new ShowingService();
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
        boolean flag = service.update(showing);

        if(flag){
            message = "更新成功";
        }else{
            message = "更新失败，请重新操作！";
        }
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

        boolean flag = service.save(showing);

        if(flag){
            message = "添加成功";
        }else{
            message = "添加失败，请重新操作！";
        }
        return "addShowing";
    }

    public String deleteShowing() throws Exception {
        boolean flag = service.remove(showing);

        if(flag){
            message = "删除成功";
        }else{
            message = "删除失败，请重新操作！";
        }
        return "deleteShowing";
    }
}
