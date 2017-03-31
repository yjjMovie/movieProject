package org.movie.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.movie.entity.Admin;
import org.movie.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/01/12.
 */
@Controller("adminAction")
@Scope("prototype")
public class AdminAction extends ActionSupport {

    //管理员业务层
    @Autowired
    AdminService service;
    //管理员集合
    private List<Admin> adminList;
    //管理员实体类
    private Admin admin;
    //返回的信息
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
    }

    public String login(){

        Admin ad  = service.findAdminByName(admin);

        if(ad == null){
            this.addActionError("用户名或密码错误！");
            System.out.println("111");
            return "loginFail";
        }else{
            ActionContext.getContext().getSession().put("admin", ad);
            return "loginSuccess";
        }
    }

    //查询全部的管理员
    public String findAdmin() {

        adminList = service.findAdmin();
        System.out.println(adminList);
        return "findAdmin";
    }

    //根据ID查询管理员
    public String findAdminById() {
        admin = service.findAdminById(admin.getAdminId());
        return "findAdminById";
    }

    //添加管理员
    public String addAdmin() {

        message = service.save(admin);
        return "addAdmin";
    }

    public String updateAdmin() {
        message = service.update(admin);
        return "updateAdmin";
    }

    public String deleteAdmin() {
        message = service.remove(admin);
        return "deleteAdmin";
    }
}
