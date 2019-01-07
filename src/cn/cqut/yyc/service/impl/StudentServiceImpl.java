package cn.cqut.yyc.service.impl;

import cn.cqut.yyc.dao.StudentDao;
import cn.cqut.yyc.entity.Student;
import cn.cqut.yyc.model.StudentModel;
import cn.cqut.yyc.service.IStudentService;
import cn.cqut.yyc.vo.StudentInfoVo;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author yinyicao
 * @DateTime 2019/1/4 13:02
 * @Blog http://www.cnblogs.com/hyyq/
 */
public class StudentServiceImpl implements IStudentService {

    StudentDao stuDao;

    public StudentServiceImpl() {
        this.stuDao = new StudentDao();
    }

    @Override
    public StudentInfoVo findAllStu() throws JsonProcessingException {
        List<StudentModel> allStudent = stuDao.findAllStudent();
        if (false == allStudent.isEmpty()) {
            //由于前端的数据绑定由layui完成，所以这里的code必须为0，msg必须为空
            return setStuvoByStu(0, "", allStudent.size(), allStudent);
        } else {
            return null;
        }
    }

    @Override
    public StudentInfoVo deleteStudentByStuId(String stuId) {

        int deleteByStuIdResult = stuDao.deleteByStuId(stuId);
        StudentInfoVo stuVo;
        if (deleteByStuIdResult > 0) {
            stuVo = setStuvoByStu(200, "成功删除" + deleteByStuIdResult + "条数据！", deleteByStuIdResult, null);
        } else {
            stuVo = setStuvoByStu(500, "删除失败,请重试！", deleteByStuIdResult, null);
        }
        return stuVo;

    }

    @Override
    public StudentInfoVo deleteStudentByStus(List<StudentModel> list) {
        int totalDeleteNum = list.size();
        int successDeleteNum = 0;
        StudentInfoVo stuVo = null;
        for (int i = 0; i < totalDeleteNum; i++) {
            stuVo = deleteStudentByStuId(list.get(i).getStudentId());
            successDeleteNum += stuVo.getCount();
        }
        if (successDeleteNum > 0) {
            stuVo = setStuvoByStu(200, "成功删除" + successDeleteNum + "条数据！", successDeleteNum, null);
        } else {
            stuVo = setStuvoByStu(500, "删除失败,请重试！", successDeleteNum, null);
        }
        return stuVo;
    }

    @Override
    public StudentInfoVo insertStudent(StudentModel stuModel) {
        StudentInfoVo stuVo = null;
        if (null != stuModel) {
            int count = stuDao.countByStuId(getStuByModel(stuModel).getStudentId());
            if (count > 0) {
                stuVo = setStuvoByStu(500, "你是不是有毒，都说了学号已存在了！", null, null);
            } else {
                int insertResult = stuDao.insertStudent(getStuByModel(stuModel));
                if (insertResult > 0) {
                    stuVo = setStuvoByStu(200, "成功插入" + insertResult + "条数据！", null, null);
                } else {
                    stuVo = setStuvoByStu(500, "插入失败,请重试！", null, null);
                }
            }
        }
        return stuVo;
    }

    @Override
    public StudentInfoVo updateStudent(StudentModel stuModel) {
        int updateResult = stuDao.updateStudent(getStuByModel(stuModel));
        StudentInfoVo stuVo;
        if (updateResult > 0) {
            stuVo = setStuvoByStu(200, "成功更新" + updateResult + "条数据！", null, null);
        } else {
            stuVo = setStuvoByStu(500, "更新失败,请重试！", null, null);
        }
        return stuVo;
    }

    @Override
    public StudentInfoVo countNumberByStus(List<StudentModel> list) {

        int totalNum = list.size();
        int countNum = 0;
        StudentInfoVo stuVo = null;
        for (int i = 0; i < totalNum; i++) {
            int count = stuDao.countByStuId(list.get(i).getStudentId());
            countNum += count;
        }
        if (countNum == 0) {
            stuVo = setStuvoByStu(200, "学号通过验证！", countNum, null);
        } else if (countNum > 0) {
            stuVo = setStuvoByStu(500, "学号已经存在，请重输！", countNum, null);
        }
        return stuVo;
    }

    @Override
    public StudentInfoVo findStuByPageAndLimit(int page, int limit) {
        List<StudentModel> allStudent;
        int startNum = (page - 1) * limit;
        int endNum = limit;
        allStudent = stuDao.findAllStuByPageAndLimit(startNum, endNum);
        int stuNum = stuDao.countAllStu();
        if (false == allStudent.isEmpty()) {
            //由于前端的数据绑定由layui完成，所以这里的code必须为0，msg必须为空
            return setStuvoByStu(0, "", stuNum, allStudent);
        } else {
            return setStuvoByStu(0, "", 0, null);
        }
    }

    @Override
    public StudentInfoVo findStuByPageAndLimitWithSearch(int page, int limit, int searchIndex, String searchContent) {
        List<StudentModel> allStudent;
        String searchName = null;
        int startNum = (page - 1) * limit;
        int endNum = limit;
        switch (searchIndex) {
            case 0:
                searchName = "stu_id";
                break;
            case 1:
                searchName = "stu_name";
                break;
            case 2:
                searchName = "stu_homeplace";
                break;
            case 3:
                searchName = "stu_instituteName";
                break;
            default:
                searchName = "stu_id";
                break;
        }
        allStudent = stuDao.findStuByPageAndLimitWithSearch(searchName, searchContent, startNum, endNum);
        int stuNum = stuDao.countAllStuWithSearch(searchName, searchContent);
        if (false == allStudent.isEmpty()) {
            //由于前端的数据绑定由layui完成，所以这里的code必须为0，msg必须为空
            return setStuvoByStu(0, "", stuNum, allStudent);
        } else {
            return setStuvoByStu(0, "", 0, null);
        }
    }


    private StudentInfoVo setStuvoByStu(Integer code, String msg, Integer count, List<StudentModel> data) {
        StudentInfoVo stuVo = new StudentInfoVo();
        stuVo.setCode(code); //固定为200或500
        stuVo.setMsg(msg);
        stuVo.setCount(count);
        stuVo.setData(data);
        return stuVo;

    }

    private Student getStuByModel(StudentModel stuModel) {
        Student stu = new Student();
        stu.setStudentId(stuModel.getStudentId());
        stu.setStudentName(stuModel.getStudentName());
        stu.setStudentAge(stuModel.getStudentAge());
        stu.setStudentGender(stuModel.getStudentGender());
        stu.setStudentEnterScore(stuModel.getStudentEnterScore());
        stu.setStudentHomeplace(stuModel.getStudentHomeplace());
        stu.setStudentInstitute(Integer.parseInt(stuModel.getStudentInstitute()));
        stu.setStudentPoliticalStatus(stuModel.getStudentPoliticalStatus());
        return stu;
    }
}
