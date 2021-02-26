package com.edu.dao;

import com.edu.bean.User;

import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-09 10:34
 * @Modified By:
 */
public interface UserDao {

    /**
     * 用户登录
     * @param account
     * @return
     */
    public boolean userLogin(String account,String password);

    /**
     *获取用户
     * @return
     */
    public List<User> getAllUser();

    /**
     * 通过用户的id 获取用户信息
     * @param userId
     * @return
     */
    public User getUserById(int userId);

    /**
     * 添加用户
     * @return
     */
    public int addUser(String account,String password,String userName,String sex,String role,String email,String phone,String address,String idCard,String content);

    /**
     * 通过用户名 获取用户信息
     * @param account
     * @return
     */
    public User findUserByAccount(String account);

    /**
     * 删除用户
     * @param useId
     * @return
     */
    public int deleteUser(int useId);
}
