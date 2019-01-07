package cn.cqut.yyc.vo;

import cn.cqut.yyc.model.StudentModel;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.List;

/**
 * @ClassName studentInfoVo
 * @Description 与layui表格的数据接口一致，可以根据layui的文档自定义
 * @Author yinyicao
 * @DateTime 2019/1/4 17:44
 * @Blog http://www.cnblogs.com/hyyq/
 */
public class StudentInfoVo {

    private Integer code;
    private String msg;
    private Integer count; //数据条数
    private List<StudentModel> data; //json字符串


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<StudentModel> getData() {
        return data;
    }

    public void setData(List<StudentModel> data) {
        this.data = data;
    }
}
