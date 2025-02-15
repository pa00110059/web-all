package com.rick.schedule.controller;

import com.rick.schedule.pojo.SysUser;
import com.rick.schedule.service.SysUserService;
import com.rick.schedule.service.impl.SysUserServiceImpl;
import com.rick.schedule.util.MD5Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;



@WebServlet("/user/*")
public class SysUserController extends BaseController {


    private SysUserService userService = new SysUserServiceImpl();

    /**
     * 接受用戶登錄請求，完成登錄的業務接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 接收用戶名和密碼
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        //2 調用服務層方法,根據用戶名查詢用戶信息
       SysUser loginUser = userService.findByUsername(username);
       if (null == loginUser) {
           // 跳轉到用戶名有誤提示頁
           resp.sendRedirect("/loginUsernameError.html");
       }else if(! MD5Util.encrypt(userPwd).equals(loginUser.getUserPwd())){
           //3 判斷密碼是否一致
           //跳轉到密碼有誤提示頁
                resp.sendRedirect("/loginUsernameError.html");
        }else {
           //4 跳轉到首頁
           resp.sendRedirect("/showSchedule.html");
       }




    }

    /**
     * 接收用戶註冊請求的業務處理方法(接口  不是java的interface)
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 接收客戶端參數
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        //2 調用服務層方法，完成註冊功能
            //將參數放入一個SYSUser對象中,在調用regist方法時傳入
        SysUser sysUser = new SysUser(null, username, userPwd);
        int rows = userService.regist(sysUser);

        //3 根據註冊結果(成功  失敗)做頁面跳轉
        if (rows > 0) {
            resp.sendRedirect("/registSuccess.html");
        }else{
            resp.sendRedirect("/registFail.html");
        }




    }
}
