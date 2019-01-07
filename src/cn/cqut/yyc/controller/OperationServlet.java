package cn.cqut.yyc.controller;

import cn.cqut.yyc.model.StudentModel;
import cn.cqut.yyc.service.IStudentService;
import cn.cqut.yyc.service.impl.StudentServiceImpl;
import cn.cqut.yyc.utility.StringUtil;
import cn.cqut.yyc.vo.DataInfoVo;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @ClassName OperationServlet
 * @Description 各种操作的controller层，增加，删除，修改调用该接口。
 * @Author yinyicao
 * @DateTime 2019/1/4 9:19
 * @Blog http://www.cnblogs.com/hyyq/
 */
public class OperationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置输入的编码格式为utf-8
        request.setCharacterEncoding("UTF-8");
        // 设置输入的编码格式为utf-8
        response.setCharacterEncoding("UTF-8");
        ///控制浏览器的行为，即控制浏览器用UTF-8进行解码；
        response.setContentType("text/javascript;charset=UTF-8");
        PrintWriter out = response.getWriter();


        //接收的vo
        DataInfoVo studentInfoVoReceive = StringUtil.receivePost(request);
        //发送的vo
        DataInfoVo studentInfoVoResponse;
        String msg = studentInfoVoReceive.getMsg();
        System.out.println("msg:" + msg);
        IStudentService stuService = new StudentServiceImpl();
        String jsonString;
        switch (msg) {
            case "deleteData":
                List<StudentModel> stuIdList = studentInfoVoReceive.getData();
                System.out.println("删除数据");
                studentInfoVoResponse = stuService.deleteStudentByStus(stuIdList);
                jsonString = StringUtil.getJsonString(studentInfoVoResponse);
                out.write(jsonString);
                break;
            case "addData":
                System.out.println("添加数据");
                jsonString = StringUtil.getJsonString(stuService.insertStudent(studentInfoVoReceive.getData().get(0)));
                out.write(jsonString);
                break;
            case "updateData":
                System.out.println("更新数据");
                jsonString = StringUtil.getJsonString(stuService.updateStudent(studentInfoVoReceive.getData().get(0)));
                out.write(jsonString);
                break;
            case "validateByStuId":
                System.out.println("验证学号");
                studentInfoVoResponse = stuService.studentIdIsExist(studentInfoVoReceive.getData());
                jsonString = StringUtil.getJsonString(studentInfoVoResponse);
                out.write(jsonString);
                break;
            default:
                System.out.println("默认操作");
                break;
        }
    }

}

