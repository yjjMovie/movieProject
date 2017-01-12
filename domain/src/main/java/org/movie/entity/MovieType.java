package org.movie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 电影类型实体类
 * Created by Administrator on 2017/01/11.
 */
@Entity
@Table(name = "movie_type")
public class MovieType {
    private int movieTypeId;
    private String movieTypeName;
    private Set<Movie> movies = new HashSet<>();

    @Id
    @GeneratedValue(generator="myuuid")
    @GenericGenerator(name="myuuid",strategy="uuid")
    @Column(name = "type_id")
    public int getMovieTypeId() {
        return movieTypeId;
    }

    public void setMovieTypeId(int movieTypeId) {
        this.movieTypeId = movieTypeId;
    }

    @Column(name = "type_name")
    public String getMovieTypeName() {
        return movieTypeName;
    }

    public void setMovieTypeName(String movieTypeName) {
        this.movieTypeName = movieTypeName;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    //多对多关联需要指定中间表，需要使用JoinTable
    //name指定中间表的表名
    //joinColumns指定自己在中间表对应的外键列
    //inverseJoinColumns指定对方在中间表的外键列
    @JoinTable(name="movie_movieType",
            joinColumns=@JoinColumn(name="type_id"),
            inverseJoinColumns=@JoinColumn(name="movie_id"))
    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
