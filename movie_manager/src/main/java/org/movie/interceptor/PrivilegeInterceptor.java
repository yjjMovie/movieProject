package org.movie.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;
import org.movie.entity.Admin;

/**
 * Created by Administrator on 2017/03/29.
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {
        Admin admin = (Admin) ServletActionContext.getRequest()
                .getSession().getAttribute("admin");
        if(admin != null){
            return invocation.invoke();
        }else{
            ActionSupport actionSupport = (ActionSupport) invocation.getAction();
            actionSupport.addActionError("您还没有登录!");
            return actionSupport.LOGIN;
        }
    }
}
