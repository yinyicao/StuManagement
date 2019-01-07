package cn.cqut.yyc.entity;

/**
 * @ClassName User
 * @Description 用户实体层
 * @Author yinyicao
 * @DateTime 2019/1/4 9:19
 * @Blog http://www.cnblogs.com/hyyq/
 */
public class User {
    private String name;
    private String pwd;
    private int role;

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User() {
        super();
    }

    public User(String name, String pwd, int role) {
        super();
        this.name = name;
        this.pwd = pwd;
        this.role = role;
    }
}