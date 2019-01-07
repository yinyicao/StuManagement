package cn.cqut.yyc.service;

import cn.cqut.yyc.model.StudentModel;
import cn.cqut.yyc.vo.StudentInfoVo;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

/**
 * @InterfaceName IStudentService
 * @Description 根据vo，给前端返回特定的数据。
 * @Author yinyicao
 * @DateTime 2019/1/4 12:59
 * @Blog http://www.cnblogs.com/hyyq/
 */
public interface IStudentService {
    StudentInfoVo findAllStu() throws JsonProcessingException;

    StudentInfoVo deleteStudentByStuId(String stuId);

    StudentInfoVo deleteStudentByStus(List<StudentModel> list);

    StudentInfoVo insertStudent(StudentModel stuModel);

    StudentInfoVo updateStudent(StudentModel stuModel);

    StudentInfoVo countNumberByStus(List<StudentModel> list);

    StudentInfoVo findStuByPageAndLimit(int page, int limit);

    StudentInfoVo findStuByPageAndLimitWithSearch(int page, int limit, int searchIndex, String searchContent);
}
