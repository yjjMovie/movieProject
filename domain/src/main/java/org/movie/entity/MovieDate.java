package org.movie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 电影年代实体类
 * Created by Administrator on 2017/01/11.
 */
@Entity
@Table(name = "movie_date")
public class MovieDate {
    private String movieDateId;
    private String movieDateName;

    @Id
    @GeneratedValue(generator="myuuid")
    @GenericGenerator(name="myuuid",strategy="uuid")
    @Column(name = "date_id")
    public String getMovieDateId() {
        return movieDateId;
    }

    public void setMovieDateId(String movieDateId) {
        this.movieDateId = movieDateId;
    }

    @Column(name = "date_name")
    public String getMovieDateName() {
        return movieDateName;
    }

    public void setMovieDateName(String movieDateName) {
        this.movieDateName = movieDateName;
    }
}
