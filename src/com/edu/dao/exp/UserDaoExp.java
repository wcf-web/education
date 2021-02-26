package com.edu.dao.exp;

import com.edu.bean.User;
import com.edu.dao.UserDao;
import com.edu.util.DruidUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-09 10:38
 * @Modified By:
 */
public class UserDaoExp extends DruidUtil implements UserDao {
    @Override
    public boolean userLogin(String account,String password) {
        // 1.定义sql语句
        String sql = "select * \n" +
                "from user \n" +
                "JOIN (SELECT roleid FROM role where rolestatus=1) as r\n" +
                "on user.roleid=r.roleid and account = ?";
        // 2. 添加参数
        List params = new ArrayList();
        params.add(account);
        // 3.执行sql语句
        set = query(sql,params);
        try {
            while (set.next()){
                if(password.equals(set.getString("password"))){
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        // 1. 定义sql语句
        String sql = "select * from user where userstatus=1";
        // 2. 参数

        // 3. 执行sql语句
        try {
            set = query(sql,null);
            while (set.next()){
                User user = new User();
                user.setUserId(set.getInt("userid"));
                user.setAccount(set.getString("account"));
                user.setUsername(set.getString("username"));
                user.setRole(set.getInt("roleid"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return userList;
    }

    @Override
    public User getUserById(int userId) {
        User user = new User();
        // 1.定义sql
        String sql = "select * from user where userid=?";
        // 2.添加参数
        List params = new ArrayList();
        params.add(userId);
        // 3. 执行sql
        try {
            set = query(sql,params);
            while (set.next()){
                user.setAccount(set.getString("account"));
                user.setPassword(set.getString("password"));
                user.setUsername(set.getString("username"));
                user.setSex(set.getString("sex"));
                user.setRole(set.getInt("roleid"));
                user.setEmail(set.getString("email"));
                user.setPhone(set.getString("phone"));
                user.setAddress(set.getString("address"));
                user.setIdCard(set.getString("idcard"));
                user.setContent(set.getString("content"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return user;
    }

    @Override
    public int addUser(String account, String password, String userName, String sex, String role, String email,
                       String phone, String address, String idCard, String content) {
        int flag = 0;
        // 1.定义sql
        String sql = "insert into user(account,password,username,sex,roleid,email," +
                "phone,address,idCard,content) values(?,?,?,?,?,?,?,?,?,?)";
        // 2.添加参数
        List params = new ArrayList();
        params.add(account);
        params.add(password);
        params.add(userName);
        params.add(sex);
        params.add(role);
        params.add(email);
        params.add(phone);
        params.add(address);
        params.add(idCard);
        params.add(content);
        // 3. 执行sql
        try {
            flag = update(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return flag;
    }

    @Override
    public User findUserByAccount(String account) {
        User user = new User();
        // 1.定义sql
        String sql = "select * from user where  account = ?";
        // 2.添加参数
        List params = new ArrayList();
        params.add(account);
        // 3.执行sql
        try {
            set = query(sql,params);
            while (set.next()){
                user.setAccount(set.getString("account"));
                user.setPassword(set.getString("password"));
                user.setUsername(set.getString("username"));
                user.setRole(set.getInt("roleid"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return user;
    }

    @Override
    public int deleteUser(int useId) {
        int flag = 0;
        // 1. 定义sql
        String sql = "update user set userstatus=0 where userid=?";
        // 2. 添加参数
        List params = new ArrayList();
        params.add(useId);
        // 3. 执行sql
        try {
            flag = update(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return flag;
    }

}




