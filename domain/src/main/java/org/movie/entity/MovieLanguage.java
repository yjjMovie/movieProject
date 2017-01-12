package org.movie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 电影语言实体类
 * Created by Administrator on 2017/01/11.
 */
@Entity
@Table(name = "movie_language")
public class MovieLanguage {
    private int movieLanguageId;
    private String movieLanguageName;
    private Set<Movie> movies = new HashSet<>();

    @Id
    @GeneratedValue(generator="myuuid")
    @GenericGenerator(name="myuuid",strategy="uuid")
    @Column(name = "language_id")
    public int getMovieLanguageId() {
        return movieLanguageId;
    }

    public void setMovieLanguageId(int movieLanguageId) {
        this.movieLanguageId = movieLanguageId;
    }

    @Column(name = "language_name")
    public String getMovieLanguageName() {
        return movieLanguageName;
    }

    public void setMovieLanguageName(String movieLanguageName) {
        this.movieLanguageName = movieLanguageName;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    //多对多关联需要指定中间表，需要使用JoinTable
    //name指定中间表的表名
    //joinColumns指定自己在中间表对应的外键列
    //inverseJoinColumns指定对方在中间表的外键列
    @JoinTable(name="movie_movieLanguage",
            joinColumns=@JoinColumn(name="language_id"),
            inverseJoinColumns=@JoinColumn(name="movie_id"))
    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
