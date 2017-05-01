package org.movie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/04/05.
 */
@Entity
@Table(name = "city_info")
public class City {
    private String cityId;
    private String cityName;
    private int ver;
    private Set<Areas> areas = new HashSet<>();

    @Id
    @GeneratedValue(generator="myuuid")
    @GenericGenerator(name="myuuid",strategy="uuid")
    @Column(name = "city_id")
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Column(name = "city_name")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Column(name = "city_ver", columnDefinition = "INT default 1")
    public int getVer() {
        return ver;
    }

    public void setVer(int ver) {
        this.ver = ver;
    }

    @OneToMany(fetch=FetchType.EAGER)
    public Set<Areas> getAreas() {
        return areas;
    }

    public void setAreas(Set<Areas> areas) {
        this.areas = areas;
    }
}
