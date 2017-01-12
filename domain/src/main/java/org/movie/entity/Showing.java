package org.movie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 电影上架实体类
 * Created by Administrator on 2017/01/11.
 */
@Entity
@Table(name = "showing_info")
public class Showing {
    private int showingId;
    //上架时间
    private Date showingTime;
    //下架时间
    private Date outawayTime;
    private Movie movie;
    private Set<Cinema> cinemas = new HashSet<>();

    @Id
    @GeneratedValue(generator="myuuid")
    @GenericGenerator(name="myuuid",strategy="uuid")
    public int getShowingId() {
        return showingId;
    }

    public void setShowingId(int showingId) {
        this.showingId = showingId;
    }

    @Column(name = "showing_time")
    public Date getShowingTime() {
        return showingTime;
    }

    public void setShowingTime(Date showingTime) {
        this.showingTime = showingTime;
    }

    @Column(name = "outaway_time")
    public Date getOutawayTime() {
        return outawayTime;
    }

    public void setOutawayTime(Date outawayTime) {
        this.outawayTime = outawayTime;
    }


    @OneToOne
    @JoinColumn(name="movie_id")
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    //一对多关联
    //fetch属性设置加载策略（延迟LAZY或者立即EAGER加载）
    //mappedBy制定维护关系交由给对方
    @OneToMany(fetch=FetchType.LAZY)
    public Set<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(Set<Cinema> cinemas) {
        this.cinemas = cinemas;
    }
}
