package cn.cqut.yyc.controller;


import cn.cqut.yyc.service.ILoginService;
import cn.cqut.yyc.service.impl.LoginServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class loginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // 设置输入的编码格式为utf-8
        request.setCharacterEncoding("utf8");
        // 设置输入的编码格式为utf-8
        response.setCharacterEncoding("utf8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
//        out.write("Hello Servlet!");
//        response.sendRedirect("main1.html");
//        request.getRequestDispatcher("main1.html").forward(request,response);//转发

//        System.out.println(DbUtil.getConnection() == null);
        //获取值查询数据库
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int role = Integer.parseInt(request.getParameter("role"));
        ILoginService loginService = new LoginServiceImpl();
        System.out.println(username + " " + password + " " + role);
        if (loginService.checkUserLogin(username, password, role)) {

            /* 登录成功 */
            // 将登录状态保存到session对象中
            request.getSession().setAttribute("flag", "login_success");


            Map<String, Object> map = new HashMap<String, Object>();
            map.put("msg", "登录成功");
            map.put("code", "1");

            ObjectMapper mapper = new ObjectMapper();
            String json;
            json = mapper.writeValueAsString(map);

            out.write(json);

        } else {
            /* 登录失败 */
            // 将登录状态修改为失败
            request.getSession().setAttribute("flag", "login_error");


            Map<String, Object> map = new HashMap<String, Object>();
            map.put("msg", "登录失败,请重试！");
            map.put("code", "2");

            ObjectMapper mapper = new ObjectMapper();
            String json;
            json = mapper.writeValueAsString(map);

            out.write(json);
        }

    }
}
