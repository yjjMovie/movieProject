package org.movie.dao.impl;

import org.movie.dao.CommentDao;
import org.movie.entity.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Administrator on 2017/04/10.
 */
@Repository("commentDao")
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentDao {
    @Override
    public List<Comment> findCommentByMovieId(String id) {
        String jpql = "select c from Comment c join c.movie m where m.movieId = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,id);
        return query.getResultList();
    }
}
