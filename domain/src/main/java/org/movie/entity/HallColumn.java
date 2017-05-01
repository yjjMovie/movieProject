package org.movie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 影厅座位列
 * Created by Administrator on 2017/04/19.
 */

@Entity
@Table(name = "hall_column")
public class HallColumn {

    private String hallColumnId;
    private String hallColumnName;
    private int ver;
    private HallRow hallRow;

    @Id
    @GeneratedValue(generator="myuuid")
    @GenericGenerator(name="myuuid",strategy="uuid")
    @Column(name = "column_id")
    public String getHallColumnId() {
        return hallColumnId;
    }

    public void setHallColumnId(String hallColumnId) {
        this.hallColumnId = hallColumnId;
    }

    @Column(name = "column_name")
    public String getHallColumnName() {
        return hallColumnName;
    }

    public void setHallColumnName(String hallColumnName) {
        this.hallColumnName = hallColumnName;
    }

    @Column(name = "ver",columnDefinition = "INT default 1")
    public int getVer() {
        return ver;
    }

    public void setVer(int ver) {
        this.ver = ver;
    }

    @ManyToOne
    @JoinColumn(name="row_id")
    public HallRow getHallRow() {
        return hallRow;
    }

    public void setHallRow(HallRow hallRow) {
        this.hallRow = hallRow;
    }
}
