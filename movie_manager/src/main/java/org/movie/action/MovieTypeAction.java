package org.movie.action;

import org.movie.entity.MovieType;
import org.movie.service.MovieTypeService;

import java.util.List;

/**
 * Created by Administrator on 2017/02/07.
 */
public class MovieTypeAction {

    //电影类型业务层
    MovieTypeService service = new MovieTypeService();
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
        List<MovieType> list = service.findMovieType();
        typeList = list;
        return "findType";
    }

    //根据ID查询电影类型
    public String findTypeById() throws Exception {
        MovieType movieType = service.findMovieTypeById(type.getMovieTypeId());
        type = movieType;
        return "findTypeById";
    }

    //更新电影类型信息
    public String updateType() throws Exception {
        boolean flag = service.update(type);

        if(flag){
            message = "更新成功";
        }else{
            message = "更新失败，请重新操作！";
        }

        return "updateType";
    }

    //添加电影类型
    public String addType() throws Exception {
        boolean flag = service.save(type);

        if(flag){
            message = "添加成功";
        }else{
            message = "添加失败，请重新操作！";
        }
        return "addType";
    }

    //删除电影类型
    public String removeType() throws Exception {
        boolean flag = service.remove(type);

        if(flag){
            message = "删除成功";
        }else{
            message = "删除失败，请重新操作！";
        }
        return "removeType";
    }

}
