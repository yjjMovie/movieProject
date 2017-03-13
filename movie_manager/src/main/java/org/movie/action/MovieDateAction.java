package org.movie.action;

import org.movie.entity.MovieDate;
import org.movie.service.MovieDateService;

import java.util.List;

/**
 * Created by Administrator on 2017/02/13.
 */
public class MovieDateAction {
    //电影年代业务层
    MovieDateService service = new MovieDateService();
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
        boolean flag = service.update(date);

        if(flag){
            message = "更新成功";
        }else{
            message = "更新失败，请重新操作！";
        }

        return "updateDate";
    }

    //添加电影年代
    public String addDate() throws Exception {
        boolean flag = service.save(date);

        if(flag){
            message = "添加成功";
        }else{
            message = "添加失败，请重新操作！";
        }
        return "addDate";
    }

    //删除电影年代
    public String removeDate() throws Exception {
        boolean flag = service.remove(date);

        if(flag){
            message = "删除成功";
        }else{
            message = "删除失败，请重新操作！";
        }
        return "removeDate";
    }

}
