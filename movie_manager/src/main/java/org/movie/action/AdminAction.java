package org.movie.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.movie.entity.Admin;
import org.movie.service.AdminService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/01/12.
 */
public class AdminAction {

    //管理员业务层
    AdminService service = new AdminService();
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

    //查询全部的管理员
    public String findAdmin() throws IOException {

        List<Admin> list = service.findAdmin();
        adminList = list;
        return "success";
    }

    //根据ID查询管理员
    public String findAdminById(){
        Admin a = service.findAdminById(admin.getAdminId());
        admin = a;
        return "success";
    }

    //添加管理员
    public String addAdmin() throws Exception {

        boolean flag = service.save(admin);
        if(flag){
            message = "添加成功";
        }else{
            message = "添加失败，请重新操作！";
        }
        return "success";
    }

    public String updateAdmin() throws Exception {
        boolean flag = service.update(admin);
        if(flag){
            message = "修改成功";
        }else{
            message = "修改失败，请重新操作！";
        }
        return "success";
    }

    public String deleteAdmin() throws Exception {
        boolean flag = service.remove(admin);
        if(flag){
            message = "删除成功";
        }else{
            message = "删除失败，请重新操作！";
        }
        return "success";
    }
}
