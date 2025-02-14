package com.atguigu.servlet;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;


/*
javaweb開發流程
1.創建javaweb項目，同時將tomcat添加為依賴
2.重寫service方法 service(HttpServletRequest req, HttpServletResponse resp)
3.在service方法中，定義業務處理代碼
4.在web.xml中，配置servlet對應的請求映射路徑

 */
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 從request對象中獲取請求中的任何信息(username參數)
        String username = request.getParameter("username");
        //2.處理業務的代碼
        String info = "YES";
        if("atguigu".equals(username)){
            info = "NO";
        }
        //3.將受響應的數據放入response
        PrintWriter writer = response.getWriter();
        writer.write(info);
    }
}
