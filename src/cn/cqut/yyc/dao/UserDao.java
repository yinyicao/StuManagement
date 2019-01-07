package cn.cqut.yyc.dao;

import cn.cqut.yyc.entity.User;
import cn.cqut.yyc.utility.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    public User findUserByNameAndPwd(String name, String pwd, int role) {
        User user = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DbUtil.getConnection();
            String sql = "select * from Table_User where username=? and password=?  and userRole=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pwd);
            ps.setInt(3, role);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setName(rs.getString("userName"));
                user.setPwd(rs.getString("passWord"));
                user.setRole(rs.getInt("userRole"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DbUtil.closeConnection(conn, ps, rs);
        }
        return user;
    }
}