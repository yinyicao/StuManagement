package cn.cqut.yyc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class logoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置输入的编码格式为utf-8
        request.setCharacterEncoding("utf8");
        // 设置输入的编码格式为utf-8
        response.setCharacterEncoding("utf8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 注销session的值
        request.getSession().invalidate();
        // 将网页重定向到首页
//        response.sendRedirect(request.getContextPath() + "/index.html");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "注销成功！");
        map.put("code", "1");

        ObjectMapper mapper = new ObjectMapper();
        String json;
        json = mapper.writeValueAsString(map);

        out.write(json);
    }
}
