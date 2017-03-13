package org.movie.action;

import org.movie.entity.User;
import org.movie.service.UserService;

import java.io.IOException;
import java.util.List;

/**
 * Created by Useristrator on 2017/01/12.
 */
public class UserAction {

    //用户业务层
    UserService service = new UserService();
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
        boolean flag = service.save(user);
        if(flag){
            message = "添加成功";
        }else{
            message = "添加失败，请重新操作！";
        }
        return "success";
    }

    public String updateUser() throws Exception {
        boolean flag = service.update(user);
        if(flag){
            message = "修改成功";
        }else{
            message = "修改失败，请重新操作！";
        }
        return "success";
    }

    public String deleteUser() throws Exception {
        boolean flag = service.remove(user);
        if(flag){
            message = "删除成功";
        }else{
            message = "删除失败，请重新操作！";
        }
        return "success";
    }
}
