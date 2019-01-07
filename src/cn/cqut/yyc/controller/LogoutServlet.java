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

/**
 * @ClassName LogoutServlet
 * @Description 注销登录的controller层，注销登陆时调用该接口。
 * @Author yinyicao
 * @DateTime 2019/1/4 9:19
 * @Blog http://www.cnblogs.com/hyyq/
 */
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置输入的编码格式为utf-8
        request.setCharacterEncoding("utf8");
        // 设置输入的编码格式为utf-8
        response.setCharacterEncoding("utf8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 注销session的值
        request.getSession().invalidate();
        Map<String, Object> map = new HashMap<>(2);
        map.put("msg", "注销成功！");
        map.put("code", "1");

        ObjectMapper mapper = new ObjectMapper();
        String json;
        json = mapper.writeValueAsString(map);

        out.write(json);
    }
}
