package org.movie.action;

import org.movie.entity.Cinema;
import org.movie.entity.MovieHall;
import org.movie.service.MovieHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2017/02/07.
 */
@Controller("movieHallAction")
@Scope("prototype")
public class MovieHallAction {

    //影厅业务层
    @Autowired
    private MovieHallService service;
    //影厅集合
    private List<MovieHall> hallList;
    //影厅实体类
    private MovieHall hall;
    //影院实体类
    private Cinema cinema;
    //返回的信息
    private String message;

    public List<MovieHall> getHallList() {
        return hallList;
    }

    public void setHallList(List<MovieHall> hallList) {
        this.hallList = hallList;
    }

    public MovieHall getHall() {
        return hall;
    }

    public void setHall(MovieHall hall) {
        this.hall = hall;
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

    //查询所有影厅
    public String findHall() throws Exception {
        List<MovieHall> list = service.findMovieHall();
        hallList = list;
        return "findHall";
    }

    //根据ID查询影厅
    public String findHallById() throws Exception {
        MovieHall movieHall = service.findMovieHallById(hall.getMovieHallId());
        hall = movieHall;
        return "findHallById";
    }

    //更新影厅信息
    public String updateHall() throws Exception {
        Cinema c = new Cinema();
        c.setCinemaId(cinema.getCinemaId());
        hall.setCinema(c);
        message = service.update(hall);

        return "updateHall";
    }

    //添加影厅
    public String addHall() throws Exception {
        Cinema c = new Cinema();
        c.setCinemaId(cinema.getCinemaId());
        hall.setCinema(c);
        message = service.save(hall);

        return "addHall";
    }

    //删除影厅
    public String removeHall() throws Exception {
        message = service.remove(hall);

        return "removeHall";
    }

}
