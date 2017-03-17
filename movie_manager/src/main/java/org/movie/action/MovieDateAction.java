package org.movie.action;

import org.movie.entity.MovieDate;
import org.movie.service.MovieDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2017/02/13.
 */

@Controller("movieDateAction")
@Scope("prototype")
public class MovieDateAction {
    //电影年代业务层
    @Autowired
    private MovieDateService service;
    //电影年代集合
    private List<MovieDate> dateList;
    //电影年代实体类
    private MovieDate date;
    //返回的信息
    private String message;


    public List<MovieDate> getDateList() {
        return dateList;
    }

    public void setDateList(List<MovieDate> dateList) {
        this.dateList = dateList;
    }

    public MovieDate getDate() {
        return date;
    }

    public void setDate(MovieDate date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //查询所有电影年代
    public String findDate() throws Exception {
        List<MovieDate> list = service.findMovieDate();
        dateList = list;
        return "findDate";
    }

    //根据ID查询电影年代
    public String findDateById() throws Exception {
        MovieDate movieDate = service.findMovieDateById(date.getMovieDateId());
        date = movieDate;
        return "findDateById";
    }

    //更新电影年代信息
    public String updateDate() throws Exception {
        message = service.update(date);

        return "updateDate";
    }

    //添加电影年代
    public String addDate() throws Exception {
        message = service.save(date);

        return "addDate";
    }

    //删除电影年代
    public String removeDate() throws Exception {
        message = service.remove(date);

        return "removeDate";
    }

}
