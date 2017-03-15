package org.movie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 电影院实体类
 * Created by Administrator on 2017/01/11.
 */
@Entity
@Table(name = "cinema_info")
public class Cinema {
    private String cinemaId;
    private String cinemaName;
    private String cinemaAddr;
    private String cinemaTel;
    private Set<MovieHall> movieHalls = new HashSet<>();

    @Id
    @GeneratedValue(generator="myuuid")
    @GenericGenerator(name="myuuid",strategy="uuid")
    @Column(name = "cinema_id")
    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    @Column(name = "cinema_name")
    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    @Column(name = "cinema_addr")
    public String getCinemaAddr() {
        return cinemaAddr;
    }

    public void setCinemaAddr(String cinemaAddr) {
        this.cinemaAddr = cinemaAddr;
    }

    @Column(name = "cinema_tel")
    public String getCinemaTel() {
        return cinemaTel;
    }

    public void setCinemaTel(String cinemaTel) {
        this.cinemaTel = cinemaTel;
    }

    //一对多关联
    //fetch属性设置加载策略（延迟LAZY或者立即EAGER加载）
    //mappedBy制定维护关系交由给对方
    @OneToMany(fetch=FetchType.EAGER, mappedBy="cinema")
    public Set<MovieHall> getMovieHalls() {
        return movieHalls;
    }

    public void setMovieHalls(Set<MovieHall> movieHalls) {
        this.movieHalls = movieHalls;
    }

}
