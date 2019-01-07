package cn.cqut.yyc.dao;

import cn.cqut.yyc.entity.Student;
import cn.cqut.yyc.model.StudentModel;
import cn.cqut.yyc.utility.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StudentDao
 * @Description TODO
 * @Author yinyicao
 * @DateTime 2019/1/4 9:19
 * @Blog http://www.cnblogs.com/hyyq/
 */
public class StudentDao {

    public int updateStudent(Student student) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            conn = DbUtil.getConnection();
            String sql = "update  table_student set stu_name=?,stu_age=?,stu_gender=?,stu_institute=?,stu_enterScore=?,stu_politicalStatus=?,stu_homeplace=? where stu_id=?";
            ps = conn.prepareStatement(sql);

            ps.setString(1, student.getStudentName());
            ps.setInt(2, student.getStudentAge());
            ps.setString(3, student.getStudentGender());
            ps.setInt(4, student.getStudentInstitute());
            ps.setInt(5, student.getStudentEnterScore());
            ps.setString(6, student.getStudentPoliticalStatus());
            ps.setString(7, student.getStudentHomeplace());
            ps.setString(8, student.getStudentId());

            result = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DbUtil.closeConnection(conn, ps, null);
        }

        return result;
    }

    public int insertStudent(Student student) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            conn = DbUtil.getConnection();
            String sql = "insert into table_student(" +
                    "stu_id,stu_name,stu_age,stu_gender,stu_institute,stu_enterScore,stu_politicalStatus,stu_homeplace)" +
                    "   values(?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, student.getStudentId());
            ps.setString(2, student.getStudentName());
            ps.setInt(3, student.getStudentAge());
            ps.setString(4, student.getStudentGender());
            ps.setInt(5, student.getStudentInstitute());
            ps.setInt(6, student.getStudentEnterScore());
            ps.setString(7, student.getStudentPoliticalStatus());
            ps.setString(8, student.getStudentHomeplace());

            result = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DbUtil.closeConnection(conn, ps, null);
        }

        return result;
    }


    public int deleteByStuId(String stuId) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            conn = DbUtil.getConnection();
            String sql = "delete from table_student where stu_id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, stuId);
            result = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DbUtil.closeConnection(conn, ps, null);
        }

        return result;
    }

    public List<StudentModel> findAllStudent() {

        List<StudentModel> stuList = new ArrayList<>();
        StudentModel stu = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DbUtil.getConnection();
            String sql = "select * from view_studentinfo";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            stuList = getStudentListByResultSet(rs);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DbUtil.closeConnection(conn, ps, rs);
        }
        return stuList;
    }

    public int countByStuId(String stuId) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;
        ResultSet rs = null;

        try {
            conn = DbUtil.getConnection();
            String sql = "select  count(stu_id) as num from table_student where stu_id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, stuId);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt("num");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DbUtil.closeConnection(conn, ps, null);
        }
        return result;
    }

    public List<StudentModel> findAllStuByPageAndLimit(int startNum, int endNum) {
        List<StudentModel> stuList = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DbUtil.getConnection();
            String sql = "select * from view_studentinfo limit ?,?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, startNum);
            ps.setInt(2, endNum);
            rs = ps.executeQuery();
            stuList = getStudentListByResultSet(rs);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DbUtil.closeConnection(conn, ps, rs);
        }
        return stuList;
    }

    public List<StudentModel> findStuByPageAndLimitWithSearch(String searchName, String searchContent, int startNum, int endNum) {
        List<StudentModel> stuList = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DbUtil.getConnection();
            String sql = "select * from view_studentinfo where " + searchName + " like ? limit ?,?";
            ps = conn.prepareStatement(sql);
//            ps.setString(1,searchName);
            ps.setString(1, "%" + searchContent + "%");
            ps.setInt(2, startNum);
            ps.setInt(3, endNum);
            System.out.println(ps.toString());
            rs = ps.executeQuery();
            stuList = getStudentListByResultSet(rs);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DbUtil.closeConnection(conn, ps, rs);
        }
        return stuList;
    }

    public int countAllStuWithSearch(String searchName, String searchContent) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;
        ResultSet rs = null;

        try {
            conn = DbUtil.getConnection();
            String sql = "select  count(*) as num from view_studentinfo where " + searchName + " like ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + searchContent + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt("num");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DbUtil.closeConnection(conn, ps, null);
        }
        return result;
    }

    public int countAllStu() {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;
        ResultSet rs = null;

        try {
            conn = DbUtil.getConnection();
            String sql = "select  count(*) as num from view_studentinfo";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt("num");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DbUtil.closeConnection(conn, ps, null);
        }
        return result;
    }

    private List<StudentModel> getStudentListByResultSet(ResultSet rs) throws SQLException {
        List<StudentModel> stuList = new ArrayList<>();
        StudentModel stu;
        while (rs.next()) {
            stu = new StudentModel();
            stu.setStudentId(rs.getString("stu_id"));
            stu.setStudentAge(rs.getInt("stu_age"));
            stu.setStudentName(rs.getString("stu_name"));
            stu.setStudentGender(rs.getString("stu_gender"));
            stu.setStudentInstitute(rs.getString("stu_instituteName"));
            stu.setStudentInstitureExplain(rs.getString("stu_instituteExplain"));
            stu.setStudentEnterScore(rs.getInt("stu_enterScore"));
            stu.setStudentHomeplace(rs.getString("stu_homeplace"));
            stu.setStudentPoliticalStatus(rs.getString("stu_politicalStatus"));
            stuList.add(stu);
        }

        return stuList;
    }

}
