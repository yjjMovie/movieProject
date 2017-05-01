package org.movie.action;

import org.movie.entity.Areas;
import org.movie.entity.City;
import org.movie.exception.NotFoundException;
import org.movie.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2017/02/13.
 */
@Controller("areaAction")
@Scope("prototype")
public class AreaAction {

    //电影地区业务层
    @Autowired
    private AreaService service;
    //电影地区集合
    private List<Areas> areaList;
    //电影地区实体类
    private Areas area;
    private City city;
    //返回的信息
    private String message;

    public List<Areas> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Areas> areaList) {
        this.areaList = areaList;
    }

    public Areas getArea() {
        return area;
    }

    public void setArea(Areas area) {
        this.area = area;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //查询所有电影地区
    public String findArea() throws Exception {
        areaList = service.findArea();
        System.out.println(areaList);
        return "findArea";
    }

    public String findAreaByCityId(){
        areaList = service.findAreaByCityId(city.getCityId());
        System.out.println(areaList);
        if(areaList.size() != 0){
            return "findAreaByCityId";
        }
        throw new NotFoundException("该城市还没有添加区域，请前往添加！");
    }

    //根据ID查询电影地区
    public String findAreaById() throws Exception {
        area = service.findAreaById(area.getAreaId());
        return "findAreaById";
    }

    //更新电影地区信息
    public String updateArea() throws Exception {
        area.setCity(city);
        message = service.update(area);
        return "updateArea";
    }

    //添加电影地区
    public String addArea() throws Exception {
        area.setCity(city);
        message = service.save(area);

        return "addArea";
    }

    //删除电影地区
    public String removeArea() throws Exception {
        message = service.remove(area);

        return "removeArea";
    }

}
