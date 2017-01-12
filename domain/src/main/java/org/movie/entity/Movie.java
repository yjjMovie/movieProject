package org.movie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 电影信息实体类
 * Created by Administrator on 2017/01/11.
 */
@Table
@Entity(name = "movie_info")
public class Movie {
    private int movieId;
    private String movieName;
    private String movieDesc;
    private String moviePhoto;
    //电影时长
    private double movieTime;
    private String movieDirect;
    private String movieActor;
    private Set<MovieType> movieTypes  = new HashSet<>();
    private MovieDate movieDate;
    private Set<MovieLanguage> movieLanguages = new HashSet<>();
    private MovieArea movieArea;


    @Id
    @GeneratedValue(generator="myuuid")
    @GenericGenerator(name="myuuid",strategy="uuid")
    @Column(name = "movie_id")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Column(name = "movie_name")
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Column(name = "movie_desc")
    public String getMovieDesc() {
        return movieDesc;
    }

    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }

    @Column(name = "movie_photo")
    public String getMoviePhoto() {
        return moviePhoto;
    }

    public void setMoviePhoto(String moviePhoto) {
        this.moviePhoto = moviePhoto;
    }

    @Column(name = "movie_time")
    public double getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(double movieTime) {
        this.movieTime = movieTime;
    }

    @Column(name = "movie_direct")
    public String getMovieDirect() {
        return movieDirect;
    }

    public void setMovieDirect(String movieDirect) {
        this.movieDirect = movieDirect;
    }

    @Column(name = "movie_actor")
    public String getMovieActor() {
        return movieActor;
    }

    public void setMovieActor(String movieActor) {
        this.movieActor = movieActor;
    }

    @ManyToMany(fetch=FetchType.LAZY,mappedBy="movies")
    public Set<MovieType> getMovieTypes() {
        return movieTypes;
    }

    public void setMovieTypes(Set<MovieType> movieTypes) {
        this.movieTypes = movieTypes;
    }

    @ManyToOne
    @JoinColumn(name="date_id")
    public MovieDate getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(MovieDate movieDate) {
        this.movieDate = movieDate;
    }

    @ManyToMany(fetch=FetchType.LAZY,mappedBy="movies")
    public Set<MovieLanguage> getMovieLanguages() {
        return movieLanguages;
    }

    public void setMovieLanguages(Set<MovieLanguage> movieLanguages) {
        this.movieLanguages = movieLanguages;
    }

    @ManyToOne
    @JoinColumn(name="ared_id")
    public MovieArea getMovieArea() {
        return movieArea;
    }

    public void setMovieArea(MovieArea movieArea) {
        this.movieArea = movieArea;
    }
}
