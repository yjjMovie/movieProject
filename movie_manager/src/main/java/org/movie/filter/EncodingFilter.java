package org.movie.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2017/01/03.
 */
public class EncodingFilter implements Filter {

    private String encoder = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init……");
            encoder = filterConfig.getInitParameter("encoder");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse resposne, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding(encoder);
        resposne.setCharacterEncoding(encoder);
        filterChain.doFilter(request, resposne);
    }

    @Override
    public void destroy() {

    }
}
