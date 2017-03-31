package org.movie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 电影场次实体类
 * Created by Administrator on 2017/01/12.
 */
@Entity
@Table(name = "movie_session")
public class MovieSession {
    private String sessionId;
    private double sessionPrice;
    //播放时间
    private Date startTime;
    //结束时间
    private Date endTime;
    private Movie movie;
    private Cinema cinema;
    private MovieHall movieHall;

    @Id
    @GeneratedValue(generator="myuuid")
    @GenericGenerator(name="myuuid",strategy="uuid")
    @Column(name = "session_id")
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Column(name = "session_price")
    public double getSessionPrice() {
        return sessionPrice;
    }

    public void setSessionPrice(double sessionPrice) {
        this.sessionPrice = sessionPrice;
    }

    @Column(name = "start_time")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Column(name = "end_time")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @ManyToOne
    @JoinColumn(name="movie_id")
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @ManyToOne
    @JoinColumn(name="cinema_id")
    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @ManyToOne
    @JoinColumn(name="hall_id")
    public MovieHall getMovieHall() {
        return movieHall;
    }

    public void setMovieHall(MovieHall movieHall) {
        this.movieHall = movieHall;
    }
}
