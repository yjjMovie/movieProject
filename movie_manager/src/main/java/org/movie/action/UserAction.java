package org.movie.action;

import org.movie.entity.User;
import org.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

/**
 * Created by Useristrator on 2017/01/12.
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction {

    //用户业务层
    @Autowired
    private UserService service;
    //用户集合
    private List<User> userList;
    //用户实体类
    private User user;
    //返回的信息
    private String message;
    
    
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
   

    //查询全部的用户
    public String findUser() throws IOException {

        List<User> list = service.findUser();
        userList = list;
        return "success";
    }

    //根据ID查询用户
    public String findUserById(){
        User a = service.findUserById(user.getUserId());
        user = a;
        return "success";
    }

    //添加用户
    public String addUser() throws Exception {
        System.out.println(user.getUserSex());
        message = service.save(user);
        return "success";
    }

    public String updateUser() throws Exception {
        message = service.update(user);
        return "success";
    }

    public String deleteUser() throws Exception {
        message = service.remove(user);
        return "success";
    }
}
