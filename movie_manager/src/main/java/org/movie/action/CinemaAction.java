package org.movie.action;

import org.movie.entity.Cinema;
import org.movie.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2017/02/06.
 */
@Controller("cinemaAction")
@Scope("prototype")
public class CinemaAction {

    //影院业务层
    @Autowired
    private CinemaService service;
    //影院集合
    private List<Cinema> cinemaList;
    //影院实体类
    private Cinema cinema;
    //返回的信息
    private String message;

    public List<Cinema> getCinemaList() {
        return cinemaList;
    }

    public void setCinemaList(List<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
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

    //查询所有影院
    public String findCinema() throws Exception {
        List<Cinema> list = service.findCinema();
        cinemaList = list;
        return "success";
    }

    public String findCinemaById() throws Exception {
        Cinema c = service.findCinemaById(cinema.getCinemaId());
        cinema = c;
        return "success";
    }

    public String update() throws Exception {
        message = service.update(cinema);
        return "success";
    }

    public String save() throws Exception {
        message = service.save(cinema);

        return "success";
    }

    public String remove() throws Exception {
        message = service.remove(cinema);

        return "success";
    }
}
