package cn.cqut.yyc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LoginFilter
 * @Description 登录过滤器，在web.xml中注册。防止未登录就进入主页
 * @Author yinyicao
 * @DateTime 2019/1/4 9:19
 * @Blog http://www.cnblogs.com/hyyq/
 */
public class LoginFilter implements Filter {
    private static final Set<String> SERVLET_PATHS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("/index.html", "/LoginServlet")));
    private static final String LOGIN_SUCCESS = "login_success";

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        // 获得访问界面的url文件地址
        String servletPath = req.getServletPath();
        HttpSession session = req.getSession();
        // 获取登录状态
        String flag = (String) session.getAttribute("flag");
        System.out.println(flag + "-->filter\n" + servletPath);

        /* 判断是否是登录页、首页、登录servlet */
        if (SERVLET_PATHS.contains(servletPath)) {
            // 是则直接转发到下一组件
            chain.doFilter(request, response);
            res.sendRedirect("/index.html");
        } else {
            // 否，则验证登录状态
            if (flag != null) {
                if (LOGIN_SUCCESS.equals(flag)) {
                    // 登录成功，直接转发到下一组件
                    chain.doFilter(request, response);
                } else {
                    // 登录失败，跳转到登录页，并保证当前网页的url文件路径
                    req.setAttribute("msg", "登录失败");
                    req.setAttribute("return_uri", servletPath);
                    res.sendRedirect("/index.html");
                }
            } else {
                // 未登录，跳转到登录页，并保证当前网页的url文件路径
                req.setAttribute("msg", "您尚未登录，请登录");
                req.setAttribute("return_uri", servletPath);
                res.sendRedirect("/index.html");
            }
        }
    }

    @Override
    public void init(FilterConfig config) {

    }

}
