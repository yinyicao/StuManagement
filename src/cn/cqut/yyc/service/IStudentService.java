package cn.cqut.yyc.service;

import cn.cqut.yyc.model.StudentModel;
import cn.cqut.yyc.vo.DataInfoVo;
import java.util.List;

/**
 * @InterfaceName IStudentService
 * @Description 根据vo，给前端返回特定的数据。
 * @Author yinyicao
 * @DateTime 2019/1/4 12:59
 * @Blog http://www.cnblogs.com/hyyq/
 */
public interface IStudentService {

    /**
     * 根据学号删除一条学生信息
     *
     * @param stuId 学号
     * @return 封装成vo返回
     **/
    DataInfoVo deleteStudentByStuId(String stuId);

    /**
     * 删除多个学生信息
     *
     * @param list 多个学生的List集合
     * @return 封装成vo返回
     */
    DataInfoVo deleteStudentByStus(List<StudentModel> list);

    /**
     * 插入一条学生信息
     *
     * @param stuModel
     * @return 封装成vo返回
     */
    DataInfoVo insertStudent(StudentModel stuModel);

    /**
     * 更新一条学生信息
     *
     * @param stuModel
     * @return 封装成vo返回
     */
    DataInfoVo updateStudent(StudentModel stuModel);

    /**
     * 验证学号是否存在
     *
     * @param list 多个学生信息，里面至少有学号字段不为空
     * @return 封装成vo返回
     */
    DataInfoVo studentIdIsExist(List<StudentModel> list);

    /**
     * 分页查询学生信息
     *
     * @param page  第几页
     * @param limit 每页有多少条
     * @return 封装成vo返回数据
     */
    DataInfoVo findStuByPageAndLimit(int page, int limit);

    /**
     * 搜索按钮将会触发的方法
     *
     * @param page
     * @param limit
     * @param searchIndex
     * @param searchContent
     * @return 封装成vo返回数据
     */
    DataInfoVo findStuByPageAndLimitWithSearch(int page, int limit, int searchIndex, String searchContent);
}
