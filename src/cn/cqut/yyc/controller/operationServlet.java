package cn.cqut.yyc.controller;

import cn.cqut.yyc.model.StudentModel;
import cn.cqut.yyc.service.IStudentService;
import cn.cqut.yyc.service.impl.StudentServiceImpl;
import cn.cqut.yyc.utility.StringUtil;
import cn.cqut.yyc.vo.StudentInfoVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class operationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置输入的编码格式为utf-8
        request.setCharacterEncoding("UTF-8");
        // 设置输入的编码格式为utf-8
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/javascript;charset=UTF-8");//控制浏览器的行为，即控制浏览器用UTF-8进行解码；
        PrintWriter out = response.getWriter();


        StudentInfoVo studentInfoVoReceive = StringUtil.receivePost(request);//接收的vo
        StudentInfoVo studentInfoVoResponse = null;//发送的vo
        String msg = studentInfoVoReceive.getMsg();
        System.out.println("msg:" + msg);
        IStudentService stuService = new StudentServiceImpl();
        String jsonString = "";
        switch (msg) {
            case "deleteData":
                List<StudentModel> stuIdList = studentInfoVoReceive.getData();
                System.out.println("删除数据");
                studentInfoVoResponse = stuService.deleteStudentByStus(stuIdList);
                jsonString = StringUtil.getJsonString(studentInfoVoResponse);
//                    jsonString = StringUtil.getJsonString(stuService.deleteStudentByStuId(studentId));
                out.write(jsonString);
                break;
            case "addData":
                System.out.println("添加数据");
                System.out.println(studentInfoVoReceive.getData().get(0).toString());
                jsonString = StringUtil.getJsonString(stuService.insertStudent(studentInfoVoReceive.getData().get(0)));
                out.write(jsonString);
                break;
            case "updateData":
                System.out.println("更新数据");
                System.out.println(studentInfoVoReceive.getData().get(0).toString());
                jsonString = StringUtil.getJsonString(stuService.updateStudent(studentInfoVoReceive.getData().get(0)));
                out.write(jsonString);
                break;
            case "validateByStuId":
                System.out.println("验证学号");
                studentInfoVoResponse = stuService.countNumberByStus(studentInfoVoReceive.getData());
                jsonString = StringUtil.getJsonString(studentInfoVoResponse);
                out.write(jsonString);
                break;
            default:
                System.out.println("默认操作");
                break;
        }
    }

}

