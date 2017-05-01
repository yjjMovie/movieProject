package org.movie.action;

import org.movie.entity.City;
import org.movie.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2017/04/05.
 */
@Controller("cityAction")
@Scope("prototype")
public class CityAction {

    @Autowired
    private CityService service;
    private List<City> cityList;
    private City city;
    private String message;

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
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

    public String findCity() throws Exception {
        cityList = service.findCity();
        System.out.println(cityList);
        return "findCity";
    }
    public String findCityById() throws Exception {
        city = service.findCityById(city.getCityId());
        return "findCityById";
    }
    public String addCity() throws Exception {
        message = service.save(city);
        return "addCity";
    }
    public String updateCity() throws Exception {
        message = service.update(city);
        return "updateCity";
    }
    public String removeCity() throws Exception {
        message = service.remove(city);
        return "deleteCity";
    }
}
