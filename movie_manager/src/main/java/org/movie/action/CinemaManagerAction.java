package org.movie.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.movie.entity.*;
import org.movie.exception.NotFoundException;
import org.movie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/04/11.
 */
@Controller("cinemaManagerAction")
@Scope("prototype")
public class CinemaManagerAction extends ActionSupport {

    @Autowired
    private CinemaManagerService service;
    @Autowired
    private CinemaService cinemaService;
    @Autowired
    private MovieHallService movieHallService;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private ShowingService showingService;
    private List<CinemaManager> cinemaManagerList;
    private List<MovieHall> movieHallList;
    private List<MovieSession> sessionList;
    private List<Showing> showingList;
    private CinemaManager cinemaManager;
    private Cinema cinema;
    private String message;

    public List<CinemaManager> getCinemaManagerList() {
        return cinemaManagerList;
    }

    public void setCinemaManagerList(List<CinemaManager> cinemaManagerList) {
        this.cinemaManagerList = cinemaManagerList;
    }

    public List<MovieHall> getMovieHallList() {
        return movieHallList;
    }

    public void setMovieHallList(List<MovieHall> movieHallList) {
        this.movieHallList = movieHallList;
    }

    public List<MovieSession> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<MovieSession> sessionList) {
        this.sessionList = sessionList;
    }

    public List<Showing> getShowingList() {
        return showingList;
    }

    public void setShowingList(List<Showing> showingList) {
        this.showingList = showingList;
    }

    public CinemaManager getCinemaManager() {
        return cinemaManager;
    }

    public void setCinemaManager(CinemaManager cinemaManager) {
        this.cinemaManager = cinemaManager;
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


    public String login(){
        CinemaManager cm  = service.findCinemaManagerByName(cinemaManager);
        System.out.println(cm);
        if(cm == null){
            this.addActionError("用户名或密码错误！");

            return "loginFail";
        }else{
            ServletActionContext.getRequest().getSession()
                    .setAttribute("cinemaManager", cm);
            return "loginSuccess";
        }
    }

    //根据ID查询影院
    public String findCinemaById(){
        System.out.println(cinema.getCinemaId());
        cinema = cinemaService.findCinemaById(cinema.getCinemaId());
        System.out.println(cinema);
        ActionContext.getContext().getSession().put("cinema", cinema);
        return "findCinemaById";
    }

    //根据影院ID查询影厅
    public String findHallByCinemaId(){
        movieHallList = movieHallService.findHallByCinemaId(cinema.getCinemaId());
        System.out.println(movieHallList);
        ActionContext.getContext().put("movieHallList", movieHallList);
        return "findHallByCinemaId";
    }

    //根据影院ID查询当前影院的场次
    public String findSessionByCinemaId() throws IOException {
        sessionList = sessionService.findSessionByCinemaId(cinema.getCinemaId());
        System.out.println(sessionList);
        ActionContext.getContext().put("sessionList", sessionList);
        return "findSessionByCinemaId";
    }

    //根据影院ID查询当前影院上映的电影
    public String findShowingByCinemaId(){
        showingList = showingService.findShowingByCinemaId(cinema.getCinemaId());
        System.out.println(showingList);
        ActionContext.getContext().put("showingList", showingList);
        return "findShowingByCinemaId";
    }


    //查询全部的影院管理员
    public String findCinemaManager() throws IOException {
        cinemaManagerList = service.findCinemaManager();
        System.out.println(cinemaManagerList);
        return "findCinemaManager";
    }

    //根据ID查询影院管理员
    public String findCinemaManagerById() throws IOException {
        cinemaManager = service.findCinemaManagerById(cinemaManager.getCinemaManagerId());
        return "findCinemaManagerById";
    }

    //根据影院ID查询影院管理员
    public String findCinemaManagerByCinemaId() throws IOException {
        cinemaManagerList = service.findCinemaManagerByCinemaId(cinema.getCinemaId());
        ActionContext.getContext().put("cinemaManagerList", cinemaManagerList);
        return "findCinemaManagerByCinemaId";
    }

    //添加影院管理员
    public String addCinemaManager() throws Exception {
        CinemaManager cm = service.findCinemaManagerByName(cinemaManager.getCinemaManagerName());
        if(cm == null){
            cinemaManager.setCinema(cinema);
            message = service.save(cinemaManager);
            return "addCinemaManager";
        }
        throw new NotFoundException("用户名已存在，请重新输入！");
    }

    //编辑影院管理员信息
    public String updateCinemaManager() throws Exception {
        CinemaManager cm = service.findCinemaManagerByName(cinemaManager.getCinemaManagerName());
        if(cm == null){
            cinemaManager.setCinema(cinema);
            message = service.update(cinemaManager);
            return "updateCinemaManager";
        }
        throw new NotFoundException("用户名已存在，请重新输入！");
    }

    //删除影院管理员
    public String removeCinemaManager() throws Exception {
        message = service.remove(cinemaManager);
        return "deleteCinemaManager";
    }
}
