package com.rick.schedule.filter;

import com.alibaba.druid.sql.visitor.functions.If;
import com.rick.schedule.pojo.SysUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/showsSchedule.html","/schedule/*"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //參數父轉子
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //獲得session域對象
        HttpSession session = request.getSession();
        //從session域中獲得登錄的用戶對象
        SysUser sysUser = (SysUser)session.getAttribute("sysUser");

        //判斷用戶對象是否為空
        if (null == sysUser){
            //沒登錄 到login.html
        response.sendRedirect("/login.html");
        }else{
            //登錄過 放行
            filterChain.doFilter(request, response);
        }
    }
}
