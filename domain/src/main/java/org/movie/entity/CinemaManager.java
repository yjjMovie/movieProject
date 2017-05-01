package org.movie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/04/11.
 */
@Entity
@Table(name = "cinema_manager")
public class CinemaManager {

    private String cinemaManagerId;
    private String cinemaManagerName;
    private String cinemaManagerPwd;
    private int ver;
    private Cinema cinema;

    @Id
    @GeneratedValue(generator="myuuid")
    @GenericGenerator(name="myuuid",strategy="uuid")
    @Column(name = "cm_id")
    public String getCinemaManagerId() {
        return cinemaManagerId;
    }

    public void setCinemaManagerId(String cinemaManagerId) {
        this.cinemaManagerId = cinemaManagerId;
    }

    @Column(name = "cm_name")
    public String getCinemaManagerName() {
        return cinemaManagerName;
    }

    public void setCinemaManagerName(String cinemaManagerName) {
        this.cinemaManagerName = cinemaManagerName;
    }


    @Column(name = "cm_pwd")
    public String getCinemaManagerPwd() {
        return cinemaManagerPwd;
    }

    public void setCinemaManagerPwd(String cinemaManagerPwd) {
        this.cinemaManagerPwd = cinemaManagerPwd;
    }

    @Column(name = "ver")
    public int getVer() {
        return ver;
    }

    public void setVer(int ver) {
        this.ver = ver;
    }

    @ManyToOne
    @JoinColumn(name="cinema_id")
    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
}
