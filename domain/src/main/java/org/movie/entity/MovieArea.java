package org.movie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 电影国家实体类
 * Created by Administrator on 2017/01/11.
 */
@Entity
@Table(name = "movie_area")
public class MovieArea {
    private int movieAreaId;
    private String movieAreaName;


    @Id
    @GeneratedValue(generator="myuuid")
    @GenericGenerator(name="myuuid",strategy="uuid")
    public int getMovieAreaId() {
        return movieAreaId;
    }

    public void setMovieAreaId(int movieAreaId) {
        this.movieAreaId = movieAreaId;
    }

    @Column(name = "area_name")
    public String getMovieAreaName() {
        return movieAreaName;
    }

    public void setMovieAreaName(String movieAreaName) {
        this.movieAreaName = movieAreaName;
    }
}
