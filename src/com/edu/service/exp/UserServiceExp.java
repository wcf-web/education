package com.edu.service.exp;

import com.edu.bean.User;
import com.edu.dao.UserDao;
import com.edu.dao.exp.UserDaoExp;
import com.edu.service.UserService;

import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-09 10:48
 * @Modified By:
 */
public class UserServiceExp implements UserService {
    private UserDao dao = new UserDaoExp();
    @Override
    public boolean userLogin(String account, String password) {
        return dao.userLogin(account,password);
    }

    @Override
    public List<User> getAllUser() {
        return dao.getAllUser();
    }

    @Override
    public User getUserById(int userId) {
        return dao.getUserById(userId);
    }

    @Override
    public int addUser(String account, String password, String userName, String sex, String role, String email, String phone, String address, String idCard, String content) {
        return dao.addUser(account,password,userName,sex,role,email,phone,address,idCard,content);
    }

    @Override
    public User findUserByAccount(String account) {
        return dao.findUserByAccount(account);
    }

    @Override
    public int deleteUser(int useId) {
        return dao.deleteUser(useId);
    }
}
