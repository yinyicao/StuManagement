package cn.cqut.yyc.service.impl;

import cn.cqut.yyc.dao.UserDao;
import cn.cqut.yyc.entity.User;
import cn.cqut.yyc.service.ILoginService;

/**
 * @ClassName LoginServiceImpl
 * @Description TODO
 * @Author yinyicao
 * @DateTime 2018/12/28 16:11
 * @Blog http://www.cnblogs.com/hyyq/
 */
public class LoginServiceImpl implements ILoginService {

    UserDao userDao;

    public LoginServiceImpl() {
        this.userDao = new UserDao();
    }

    @Override
    public boolean checkUserLogin(String username, String password, int role) {
        User user = userDao.findUserByNameAndPwd(username, password, role);
        if (user != null)
            return true;
        else
            return false;
    }
}
