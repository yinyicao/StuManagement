package cn.cqut.yyc.service;


/**
 * @InterfaceName ILoginService
 * @Description 根据vo，给前端返回特定的数据。
 * @Author yinyicao
 * @DateTime 2019/1/4 12:59
 * @Blog http://www.cnblogs.com/hyyq/
 */
public interface ILoginService {

    /**
     * 验证用户登录的方法
     *
     * @param username 用户名
     * @param password 密码
     * @param role     角色
     * @return 是否登录成功，True：登录成功，False:登录失败
     */
    boolean checkUserLogin(String username, String password, int role);

}   
