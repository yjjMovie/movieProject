package org.movie.action;

import org.movie.condition.ItemCondition;
import org.movie.entity.OrderItem;
import org.movie.exception.NotFoundException;
import org.movie.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2017/03/30.
 */
@Controller("itemAction")
public class ItemAction {

    @Autowired
    private ItemService service;
    private OrderItem item;
    private List<OrderItem> itemList;
    private String message;
    private ItemCondition condition;

    public ItemCondition getCondition() {
        return condition;
    }

    public void setCondition(ItemCondition condition) {
        this.condition = condition;
    }

    public OrderItem getItem() {
        return item;
    }

    public void setItem(OrderItem item) {
        this.item = item;
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderItem> itemList) {
        this.itemList = itemList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String findItem(){
        itemList = service.findItem();
        if(itemList.size() != 0){
            System.out.println(itemList);
            return "findItem";
        }
        System.out.println(itemList);
        throw new NotFoundException("抱歉，没有查询到相关的结果");
    }

    public String findItemByCondition(){
        System.out.println(condition.getUserName());
        itemList = service.findItemByCondition(condition);
        if(itemList.size() != 0){
            System.out.println(itemList);
            return "findItemByCondition";
        }
        System.out.println(itemList);
        throw new NotFoundException("抱歉，没有查询到相关的结果");
    }
}
