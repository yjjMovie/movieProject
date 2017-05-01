package org.movie.action;

import org.movie.entity.Areas;
import org.movie.entity.City;
import org.movie.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2017/04/05.
 */
@Controller("areaAction")
@Scope("prototype")
public class AreaAction {

    @Autowired
    private AreaService service;
    private List<Areas> areaList;
    private City city;

    public List<Areas> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Areas> areaList) {
        this.areaList = areaList;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String findAreaByCityId() throws Exception {
        areaList = service.findAreaByCityId(city.getCityId());
        return "findAreaByCityId";
    }
}
