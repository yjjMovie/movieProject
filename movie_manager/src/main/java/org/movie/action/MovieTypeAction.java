package org.movie.action;

import org.movie.entity.MovieType;
import org.movie.service.MovieTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2017/02/07.
 */

@Controller("movieTypeAction")
@Scope("prototype")
public class MovieTypeAction {

    //电影类型业务层
    @Autowired
    private MovieTypeService service;
    //电影类型集合
    private List<MovieType> typeList;
    //电影类型实体类
    private MovieType type;
    //返回的信息
    private String message;

    public List<MovieType> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<MovieType> typeList) {
        this.typeList = typeList;
    }

    public MovieType getType() {
        return type;
    }

    public void setType(MovieType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //查询所有电影类型
    public String findType() throws Exception {
        typeList = service.findMovieType();
        System.out.println(typeList);
        return "findType";
    }

    //根据ID查询电影类型
    public String findTypeById() throws Exception {
        type = service.findMovieTypeById(type.getMovieTypeId());
        return "findTypeById";
    }

    //更新电影类型信息
    public String updateType() throws Exception {
        message = service.update(type);

        return "updateType";
    }

    //添加电影类型
    public String addType() throws Exception {
        message = service.save(type);

        return "addType";
    }

    //删除电影类型
    public String removeType() throws Exception {
        message = service.remove(type);

        return "removeType";
    }

}
