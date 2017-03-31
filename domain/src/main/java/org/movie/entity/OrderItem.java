package org.movie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 购票订单项实体类
 * Created by Administrator on 2017/01/12.
 */
@Entity
@Table(name = "order_item")
public class OrderItem {
    private String itemId;
    //购票数量
    private int itemNum;
    //下单时间
    private Date itemTime;
    //小计
    private double subtotal;
    //关联的用户
    private User user;
    //关联的场次
    private MovieSession movieSession;

    @Id
    @GeneratedValue(generator="myuuid")
    @GenericGenerator(name="myuuid",strategy="uuid")
    @Column(name = "item_id")
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Column(name = "item_num")
    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    @Column(name = "item_time")
    public Date getItemTime() {
        return itemTime;
    }

    public void setItemTime(Date itemTime) {
        this.itemTime = itemTime;
    }

    @Column(name = "subtotal")
    public double getSubtotal() {
        return movieSession.getSessionPrice() * getItemNum();
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @ManyToOne
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name="session_id")
    public MovieSession getMovieSession() {
        return movieSession;
    }

    public void setMovieSession(MovieSession movieSession) {
        this.movieSession = movieSession;
    }
}
