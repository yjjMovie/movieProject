package org.movie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 影厅实体类
 * Created by Administrator on 2017/01/11.
 */
@Entity
@Table(name = "movie_hall")
public class MovieHall {
    private String movieHallId;
    private String movieHallName;
    private int seatingNum;
    private int seatColumn;
    private int seatRow;
    private Cinema cinema;


    @Id
    @GeneratedValue(generator="myuuid")
    @GenericGenerator(name="myuuid",strategy="uuid")
    @Column(name = "hall_id")
    public String getMovieHallId() {
        return movieHallId;
    }

    public void setMovieHallId(String movieHallId) {
        this.movieHallId = movieHallId;
    }

    @Column(name = "hall_name")
    public String getMovieHallName() {
        return movieHallName;
    }

    public void setMovieHallName(String movieHallName) {
        this.movieHallName = movieHallName;
    }

    @Column(name = "seating_num")
    public int getSeatingNum() {
        return seatColumn * seatRow;
    }

    public void setSeatingNum(int seatingNum) {
        this.seatingNum = seatingNum;
    }

    @Column(name = "seat_column")
    public int getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(int seatColumn) {
        this.seatColumn = seatColumn;
    }

    @Column(name = "seat_row")
    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
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
