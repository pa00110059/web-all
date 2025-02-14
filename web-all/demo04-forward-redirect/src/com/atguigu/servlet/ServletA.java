package com.atguigu.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servletA")
public class ServletA extends HttpServlet {

    /*
    1 請求轉發是通過HttpServletRequest對象實現的
    2.請求轉發是服務器內部行為，對客戶端是屏蔽的
    3 客戶端只產生了一次請求   服務端只產生了一對request及response
    4 客戶端的地址欄是不變的
    5 請求的參數是可以繼續傳遞的
    6 目標資源可以是servlet動態資源，也可以是html靜態資源
    7 目標資源可以是WEB-INF下的受保護的資源 該方式也是訪問WEB-INF下的資源的唯一方式
    8 目標資源不可以是外部的資源

     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletA Started");

        String money = req.getParameter("money");
        System.out.println("servletA got money = " + money);

        //請求轉發給servletB
        //獲得請求轉發器
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("a.html");
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/b.html");
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("http://www.atguigu.com");
        //讓請求轉發器做出轉發動作
        requestDispatcher.forward(req, resp);
    }
}
