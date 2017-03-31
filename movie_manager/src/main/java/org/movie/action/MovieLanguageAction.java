package org.movie.action;

import org.movie.entity.MovieLanguage;
import org.movie.service.MovieLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2017/02/14.
 */
@Controller("movieLanguageAction")
@Scope("prototype")
public class MovieLanguageAction {

    //电影语言业务层
    @Autowired
    private MovieLanguageService service;
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
        languageList = service.findMovieLanguage();
        System.out.println(languageList);
        return "findLanguage";
    }

    //根据ID查询电影语言
    public String findLanguageById() throws Exception {
        language = service.findMovieLanguageById(language.getMovieLanguageId());
        return "findLanguageById";
    }

    //更新电影语言信息
    public String updateLanguage() throws Exception {
        message = service.update(language);

        return "updateLanguage";
    }

    //添加电影语言
    public String addLanguage() throws Exception {
        message = service.save(language);

        return "addLanguage";
    }

    //删除电影语言
    public String removeLanguage() throws Exception {
        message = service.remove(language);

        return "removeLanguage";
    }

}
