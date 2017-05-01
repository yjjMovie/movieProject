package org.movie.action;

import org.movie.entity.Areas;
import org.movie.entity.Cinema;
import org.movie.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2017/04/06.
 */
@Controller("cinemaAction")
@Scope("prototype")
public class CinemaAction {

    @Autowired
    private CinemaService service;
    private List<Cinema> cinemaList;
    private Cinema cinema;
    private Areas area;

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

    public String findCinemaByAreaId() throws Exception {
        cinemaList = service.findCinemaByAreaId(area.getAreaId());
        return "findCinemaByAreaId";
    }
}
