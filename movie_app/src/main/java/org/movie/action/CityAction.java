package org.movie.action;

import org.movie.entity.City;
import org.movie.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2017/04/05.
 */
@Controller("cityAction")
public class CityAction {

    @Autowired
    private CityService service;
    private List<City> cityList;

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public String findCity() throws Exception {
        cityList = service.findCity();
        return "findCity";
    }
}
