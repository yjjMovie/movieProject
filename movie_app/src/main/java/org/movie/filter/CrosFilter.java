package org.movie.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangl on 2017/3/13.
 */
public class CrosFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        //相应之前设置响应的头部，授权跨域访问
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setDateHeader("Expires", 0);
        //放行
        filterChain.doFilter(req,res);

    }

    @Override
    public void destroy() {

    }
}
