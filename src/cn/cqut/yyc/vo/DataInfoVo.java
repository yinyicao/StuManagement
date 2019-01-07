package cn.cqut.yyc.vo;


import cn.cqut.yyc.model.StudentModel;

import java.util.List;

/**
 * @ClassName DataInfoVo
 * @Description 与layui表格的数据接口一致，可以根据layui的文档自定义
 * 与前端交互数据，统一Json格式串
 * @Author yinyicao
 * @DateTime 2019/1/4 17:44
 * @Blog http://www.cnblogs.com/hyyq/
 */
public class DataInfoVo {

    /**
     * 响应码
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String msg;
    /**
     * 数据条数
     */
    private Integer count;
    /**
     * 真正的数据
     */
    private List<StudentModel> data;


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
