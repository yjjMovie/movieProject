package org.movie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

/**
 * 影厅座位行
 * Created by Administrator on 2017/04/19.
 */
@Entity
@Table(name = "hall_row")
public class HallRow {

    private String hallRowId;
    private String hallRowName;
    private int ver;
    private MovieHall movieHall;
    private List<HallColumn> hallColumns = new ArrayList<>();

    @Id
    @GeneratedValue(generator="myuuid")
    @GenericGenerator(name="myuuid",strategy="uuid")
    @Column(name = "row_id")
    public String getHallRowId() {
        return hallRowId;
    }

    public void setHallRowId(String hallRowId) {
        this.hallRowId = hallRowId;
    }

    @Column(name = "row_name")
    public String getHallRowName() {
        return hallRowName;
    }

    public void setHallRowName(String hallRowName) {
        this.hallRowName = hallRowName;
    }

    @Column(name = "ver",columnDefinition = "INT default 1")
    public int getVer() {
        return ver;
    }

    public void setVer(int ver) {
        this.ver = ver;
    }

    @ManyToOne
    @JoinColumn(name="hall_id")
    public MovieHall getMovieHall() {
        return movieHall;
    }

    public void setMovieHall(MovieHall movieHall) {
        this.movieHall = movieHall;
    }

    @OneToMany(fetch=FetchType.EAGER, mappedBy = "hallRow")
    public List<HallColumn> getHallColumns() {
        return hallColumns;
    }

    public void setHallColumns(List<HallColumn> hallColumns) {
        this.hallColumns = hallColumns;
    }
}
