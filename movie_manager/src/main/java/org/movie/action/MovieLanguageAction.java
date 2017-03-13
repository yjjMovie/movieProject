package org.movie.action;

import org.movie.entity.MovieLanguage;
import org.movie.service.MovieLanguageService;

import java.util.List;

/**
 * Created by Administrator on 2017/02/14.
 */
public class MovieLanguageAction {

    //电影语言业务层
    MovieLanguageService service = new MovieLanguageService();
    //电影语言集合
    private List<MovieLanguage> languageList;
    //电影语言实体类
    private MovieLanguage language;
    //返回的信息
    private String message;

    public List<MovieLanguage> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<MovieLanguage> languageList) {
        this.languageList = languageList;
    }

    public MovieLanguage getLanguage() {
        return language;
    }

    public void setLanguage(MovieLanguage language) {
        this.language = language;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //查询所有电影语言
    public String findLanguage() throws Exception {
        List<MovieLanguage> list = service.findMovieLanguage();
        languageList = list;
        return "findLanguage";
    }

    //根据ID查询电影语言
    public String findLanguageById() throws Exception {
        MovieLanguage movieLanguage = service.findMovieLanguageById(language.getMovieLanguageId());
        language = movieLanguage;
        return "findLanguageById";
    }

    //更新电影语言信息
    public String updateLanguage() throws Exception {
        boolean flag = service.update(language);

        if(flag){
            message = "更新成功";
        }else{
            message = "更新失败，请重新操作！";
        }

        return "updateLanguage";
    }

    //添加电影语言
    public String addLanguage() throws Exception {
        boolean flag = service.save(language);

        if(flag){
            message = "添加成功";
        }else{
            message = "添加失败，请重新操作！";
        }
        return "addLanguage";
    }

    //删除电影语言
    public String removeLanguage() throws Exception {
        boolean flag = service.remove(language);

        if(flag){
            message = "删除成功";
        }else{
            message = "删除失败，请重新操作！";
        }
        return "removeLanguage";
    }

}
