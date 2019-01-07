package cn.cqut.yyc.utility;

import com.sun.corba.se.impl.orbutil.closure.Constant;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName DbUtil
 * @Description TODO
 * @Author yinyicao
 * @DateTime 2018/12/28 15:33
 * @Blog http://www.cnblogs.com/hyyq/
 */
public class DbUtil {

    private static String DRIVER = "";
    private static String URL = "";
    private static String USERNAME = "";
    private static String PASSWORD = "";


    //从properties文件中获取连接数据库所需的参数
    static {
        try {
            Properties prop = new Properties();
            InputStream in = DbUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            prop.load(in);
            DRIVER = prop.getProperty("jdbc.driver");
            URL = prop.getProperty("jdbc.url");
            USERNAME = prop.getProperty("jdbc.username");
            PASSWORD = prop.getProperty("jdbc.password");
            System.out.println(DRIVER + "..." + URL + "..." + USERNAME + "..." + PASSWORD);
        } catch (FileNotFoundException e) {
            System.out.println("找不到文件！");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("读取properties文件出错!");
            e.printStackTrace();
        }
    }


    //获取数据库连接
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭连接
    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
