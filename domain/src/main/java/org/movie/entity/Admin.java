package org.movie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 管理员实体类
 * Created by Administrator on 2017/01/11.
 */
@Entity
@Table(name = "admin_info")
public class Admin {

    private String adminId;
    private String adminName;
    private String adminPassword;
    private int ver;


    @Id
    @GeneratedValue(generator="myuuid")
    @GenericGenerator(name="myuuid",strategy="uuid")
    @Column(name = "admin_id")
    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    @Column(name = "admin_name")
    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Column(name = "admin_password")
    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Column(name = "ver")
    public int getVer() {
        return ver;
    }

    public void setVer(int ver) {
        this.ver = ver;
    }
}
