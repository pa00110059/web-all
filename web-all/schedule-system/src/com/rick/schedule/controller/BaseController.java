package com.rick.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判斷此次請求時 增?刪?改?查?

        String requestURI = req.getRequestURI(); // /schedule/add
        String[] split = requestURI.split("/");
        String methodName = split[split.length - 1];
        /*
        if (methodName.equals("add")) {
            //做增加處理
            add(req, resp);
        } else if (methodName.equals("find")) {
            //做查詢處理
            find(req, resp);
        } else if (methodName.equals("update")) {
            //做修改處理
            update(req, resp);
        } else if (methodName.equals("remove")) {
            //做刪除處理
            remove(req, resp);
        }
       */

        //使用 反射 通過方法名獲取下面的方法
        Class aClass = this.getClass();
        // 獲取方法
        try {
            Method declaredMethod = aClass.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            //暴力 破解方法的訪問修飾符的限制
            declaredMethod.setAccessible(true);

            //執行方法
            declaredMethod.invoke(this,req,resp);
        } catch (Exception e) {
            //沒有輸入指定的方法會報錯異常日誌
            e.printStackTrace();
        }


    }
}
