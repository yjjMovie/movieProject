package org.movie.action;

import org.movie.entity.MovieArea;
import org.movie.service.MovieAreaService;

import java.util.List;

/**
 * Created by Administrator on 2017/02/13.
 */
public class MovieAreaAction {

    //电影地区业务层
    MovieAreaService service = new MovieAreaService();
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
        List<MovieArea> list = service.findMovieArea();
        areaList = list;
        return "findArea";
    }

    //根据ID查询电影地区
    public String findAreaById() throws Exception {
        MovieArea movieArea = service.findMovieAreaById(area.getMovieAreaId());
        area = movieArea;
        return "findAreaById";
    }

    //更新电影地区信息
    public String updateArea() throws Exception {
        boolean flag = service.update(area);

        if(flag){
            message = "更新成功";
        }else{
            message = "更新失败，请重新操作！";
        }

        return "updateArea";
    }

    //添加电影地区
    public String addArea() throws Exception {
        boolean flag = service.save(area);

        if(flag){
            message = "添加成功";
        }else{
            message = "添加失败，请重新操作！";
        }
        return "addArea";
    }

    //删除电影地区
    public String removeArea() throws Exception {
        boolean flag = service.remove(area);

        if(flag){
            message = "删除成功";
        }else{
            message = "删除失败，请重新操作！";
        }
        return "removeArea";
    }

}
