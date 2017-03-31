package org.movie.service;

import org.movie.condition.ItemCondition;
import org.movie.dao.ItemDao;
import org.movie.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/03/30.
 */
@Service
@Transactional
public class ItemService {
    @Autowired
    private ItemDao dao;

    public List<OrderItem> findItem(){

        return dao.findList(OrderItem.class);
    }

    public List<OrderItem> findItemByCondition(ItemCondition condition){
        StringBuilder jpql = new StringBuilder();
        Map<String, Object> map = new HashMap();
        jpql.append("from OrderItem i where 1=1");
        if(condition != null){
            if(condition.getUserName() != null && !"".equals(condition.getUserName())){
                jpql.append(" and i.user.userName = :userName");
                map.put("userName", condition.getUserName());
            }
            if(condition.getMovieName() != null && !"".equals(condition.getMovieName())){
                jpql.append(" and i.movieSession.movie.movieName = :movieName");
                map.put("movieName", condition.getMovieName());
            }
            if(condition.getCinemaName() != null && !"".equals(condition.getCinemaName())){
                jpql.append(" and i.movieSession.cinema.cinemaName = :cinemaName");
                map.put("cinemaName", condition.getCinemaName());
            }
        }
        return dao.findItemByCondition(jpql.toString(), map);
    }
}
