package org.movie.action;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.movie.entity.*;
import org.movie.entity.Movie;
import org.movie.service.MovieService;
import org.movie.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/02/14.
 */
@Controller("movieAction")
@Scope("prototype")
public class MovieAction {

    //电影信息业务层
    @Autowired
    private MovieService service;
    //电影实体集合
    private List<Movie> movieList;
    //电影实体类
    private Movie movie;
    //电影类型实体类
    private String[] type;
    //电影地区实体类
    private MovieArea area;
    //电影语言实体类
    private String[] language;
    //电影年代实体类
    private MovieDate date;
    //表单文件，必须是一个File类型
    private File uploadFile;
    //上传的文件名，格式必须是File名称加上FileName
    private String uploadFileFileName;
    //上传的文件类型，格式必须是File名称加上ContentType
    private String uploadFileContentType;
    private String message;
    private int pageNum;
    private PageBean pageBean;

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public MovieArea getArea() {
        return area;
    }

    public void setArea(MovieArea area) {
        this.area = area;
    }

    public String[] getLanguage() {
        return language;
    }

    public void setLanguage(String[] language) {
        this.language = language;
    }

    public MovieDate getDate() {
        return date;
    }

    public void setDate(MovieDate date) {
        this.date = date;
    }

    public File getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(File uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String getUploadFileFileName() {
        return uploadFileFileName;
    }

    public void setUploadFileFileName(String uploadFileFileName) {
        this.uploadFileFileName = uploadFileFileName;
    }

    public String getUploadFileContentType() {
        return uploadFileContentType;
    }

    public void setUploadFileContentType(String uploadFileContentType) {
        this.uploadFileContentType = uploadFileContentType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    //查询所有电影
    public String findMovie() throws Exception {
        pageBean = service.findMovie(pageNum);
        return "findMovie";
    }

    //根据ID查询电影
    public String findMovieById() throws Exception {
        Movie m = service.findMovieById(movie.getMovieId());
        movie = m;
        return "findMovieById";
    }

    //更新电影信息
    public String updateMovie() throws Exception {
        uploadImg();

        MovieArea movieArea = new MovieArea();
        movieArea.setMovieAreaId(area.getMovieAreaId());
        movie.setMovieArea(movieArea);

        MovieDate movieDate = new MovieDate();
        movieDate.setMovieDateId(date.getMovieDateId());
        movie.setMovieDate(movieDate);

        for(int i=0;i<type.length;i++){
            MovieType movieType = new MovieType();
            movieType.setMovieTypeId(type[i]);
            movie.getMovieTypes().add(movieType);
        }

        for(int i=0;i<language.length;i++){
            MovieLanguage movieLanguage = new MovieLanguage();
            movieLanguage.setMovieLanguageId(language[i]);
            movie.getMovieLanguages().add(movieLanguage);
        }
        message = service.updateMovie(movie);

        return "updateMovie";
    }

    //添加电影
    public String addMovie() throws Exception {

        uploadImg();

        MovieArea movieArea = new MovieArea();
        movieArea.setMovieAreaId(area.getMovieAreaId());
        movie.setMovieArea(movieArea);

        MovieDate movieDate = new MovieDate();
        movieDate.setMovieDateId(date.getMovieDateId());
        movie.setMovieDate(movieDate);

        for(int i=0;i<type.length;i++){
            MovieType movieType = new MovieType();
            movieType.setMovieTypeId(type[i]);
            movie.getMovieTypes().add(movieType);
        }

        for(int i=0;i<language.length;i++){
            MovieLanguage movieLanguage = new MovieLanguage();
            movieLanguage.setMovieLanguageId(language[i]);
            movie.getMovieLanguages().add(movieLanguage);
        }
        message = service.saveMovie(movie);
        return "addMovie";
    }

    //删除电影
    public String removeMovie() throws Exception {
        System.out.println(movie.getMovieId());
        message = service.removeMovie(movie);

        return "removeMovie";
    }


    private void uploadImg() throws IOException {
        //获取上传的绝对路径
        String uploadPath = ServletActionContext.getServletContext().getRealPath("/images");
        String path = uploadPath.replace("target\\movie_manager-1.0-SNAPSHOT\\images", "web\\images");
        //判断提交过来的File不为null，才执行上传操作
        if(uploadFile != null) {
            //根据文件名以及上传的路径构建一个新的File对象
            File saveFile = new File(path, uploadFileFileName);
            //先判断上的目录是否存在，如果不存在则创建出来
            System.out.println(saveFile.getParentFile().exists());
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            //使用文件复制执行上传
            FileUtils.copyFile(uploadFile, saveFile);
            //String photo = path + "\\" + uploadFileFileName;
            String photo =  uploadFileFileName;
            movie.setMoviePhoto(photo);
        }
    }
}
