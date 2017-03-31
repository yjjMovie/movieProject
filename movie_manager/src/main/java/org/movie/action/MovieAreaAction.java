package org.movie.action;

import org.movie.entity.MovieArea;
import org.movie.service.MovieAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2017/02/13.
 */
@Controller("movieAreaAction")
@Scope("prototype")
public class MovieAreaAction {

    //电影地区业务层
    @Autowired
    private MovieAreaService service;
    //电影地区集合
    private List<MovieArea> areaList;
    //电影地区实体类
    private MovieArea area;
    //返回的信息
    private String message;

    public List<MovieArea> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<MovieArea> areaList) {
        this.areaList = areaList;
    }

    public MovieArea getArea() {
        return area;
    }

    public void setArea(MovieArea area) {
        this.area = area;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //查询所有电影地区
    public String findArea() throws Exception {
        areaList = service.findMovieArea();
        System.out.println(areaList);
        return "findArea";
    }

    //根据ID查询电影地区
    public String findAreaById() throws Exception {
        area = service.findMovieAreaById(area.getMovieAreaId());
        return "findAreaById";
    }

    //更新电影地区信息
    public String updateArea() throws Exception {
        message = service.update(area);
        return "updateArea";
    }

    //添加电影地区
    public String addArea() throws Exception {
        message = service.save(area);

        return "addArea";
    }

    //删除电影地区
    public String removeArea() throws Exception {
        message = service.remove(area);

        return "removeArea";
    }

}
