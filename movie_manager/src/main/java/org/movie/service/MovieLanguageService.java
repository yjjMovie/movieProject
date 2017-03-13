package org.movie.service;

import org.movie.dao.BaseDao;
import org.movie.entity.MovieLanguage;

import java.util.List;

/**
 * Created by Administrator on 2017/02/14.
 */
public class MovieLanguageService {

    BaseDao<MovieLanguage> dao = new BaseDao<>();

    public List<MovieLanguage> findMovieLanguage() {
        List<MovieLanguage> list = dao.findList(MovieLanguage.class);
        /*for (MovieLanguage language : list) {
            language.setMovie(null);
        }*/
        return list;
    }

    public MovieLanguage findMovieLanguageById(String movieLanguageId) {
        MovieLanguage language  = dao.findById(MovieLanguage.class, movieLanguageId);
        //language.setMovie(null);
        return language;
    }

    public boolean update(MovieLanguage language) {
        return dao.update(language);
    }

    public boolean save(MovieLanguage language) {
        return dao.save(language);
    }

    public boolean remove(MovieLanguage language) {
        return dao.remove(language);
    }
}
