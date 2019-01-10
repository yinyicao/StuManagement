package cn.cqut.yyc.controller;

import cn.cqut.yyc.service.IStudentService;
import cn.cqut.yyc.service.impl.StudentServiceImpl;
import cn.cqut.yyc.utility.StringUtil;
import cn.cqut.yyc.vo.DataInfoVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName GetDataServlet
 * @Description 数据获取接口
 * @Author yinyicao
 * @DateTime 2019/1/4 9:19
 * @Blog http://www.cnblogs.com/hyyq/
 */
public class GetDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置输入的编码格式为utf-8
        request.setCharacterEncoding("UTF-8");
        // 设置输入的编码格式为utf-8
        response.setCharacterEncoding("UTF-8");
        //控制浏览器的行为，即控制浏览器用UTF-8进行解码；
        response.setContentType("text/html;charset=UTF-8");
        String pageStr = request.getParameter("page");
        String limitStr = request.getParameter("limit");
        int page = Integer.parseInt(pageStr);
        int limit = Integer.parseInt(limitStr);
        System.out.println("page=" + page + "limit=" + limit);
        PrintWriter out = response.getWriter();

        String searchIndexStr = request.getParameter("searchIndex");
        String searchContent = request.getParameter("searchContent");
        System.out.println("page=" + page + "limit=" + limit + "searchIndex=" + searchIndexStr + "searchContent=" + searchContent);

        //不是点击搜索按钮触发的事件,只做分页查询即可
        if (null == searchIndexStr || "".equals(searchIndexStr)) {
            outputAllStuWithPageLimit(out, page, limit);
        } else { //是点击搜索按钮触发的事件,做分页查询并做搜索查询
            Integer searchIndex = Integer.parseInt(searchIndexStr);
            outputAllStuWithPageLimitAndSearch(out, page, limit, searchIndex, searchContent);
        }
    }

    /**
     * 搜索的数据返回
     *
     * @param out           PrintWriter对象
     * @param page          页
     * @param limit         每页条数
     * @param searchIndex   搜索的索引项
     * @param searchContent 搜索的内容
     * @throws JsonProcessingException json格式转换异常
     */
    private void outputAllStuWithPageLimitAndSearch(PrintWriter out, Integer page, Integer limit, Integer searchIndex, String searchContent) throws JsonProcessingException {
        IStudentService stuService = new StudentServiceImpl();
        DataInfoVo allStu = stuService.findStuByPageAndLimitWithSearch(page, limit, searchIndex, searchContent);
        if (null != allStu) {
            String jsonData = StringUtil.getJsonString(allStu);
            out.write(jsonData);
        }
    }


    /**
     * 分页的数据返回
     *
     * @param out   PrintWriter对象
     * @param page  页
     * @param limit 每页条数
     * @throws JsonProcessingException json格式转换错误
     */
    private void outputAllStuWithPageLimit(PrintWriter out, int page, int limit) throws JsonProcessingException {
        IStudentService stuService = new StudentServiceImpl();
        DataInfoVo allStu = stuService.findStuByPageAndLimit(page, limit);
        if (null != allStu) {
            String jsonData = StringUtil.getJsonString(allStu);
            out.write(jsonData);
        }
    }
}
