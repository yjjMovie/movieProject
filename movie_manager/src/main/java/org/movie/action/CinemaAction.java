package org.movie.action;

import org.movie.entity.Areas;
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
    private Areas area;
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

    public Areas getArea() {
        return area;
    }

    public void setArea(Areas area) {
        this.area = area;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //查询所有影院
    public String findCinema() throws Exception {
        cinemaList = service.findCinema();
        System.out.println(cinemaList);
        return "findCinema";
    }

    public String findCinemaById() throws Exception {
        cinema = service.findCinemaById(cinema.getCinemaId());
        return "findCinemaById";
    }

    public String updateCinema() throws Exception {
        cinema.setArea(area);
        message = service.update(cinema);
        return "updateCinema";
    }

    public String addCinema() throws Exception {
        cinema.setArea(area);
        message = service.save(cinema);
        return "addCinema";
    }

    public String deleteCinema() throws Exception {
        message = service.remove(cinema);
        return "deleteCinema";
    }
}
