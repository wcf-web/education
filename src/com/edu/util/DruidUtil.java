package com.edu.util;

import com.alibaba.druid.pool.DruidDataSource;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @Desc:   Druid连接工具类
 * @Author: chunfeng
 * @Date
 */
public class DruidUtil {
    protected static Connection con = null;
    protected static PreparedStatement state = null;
    protected static ResultSet set = null;
    private static String driveClass;
    private static String url;
    private static String username;
    private static String password;
    private static int maxwait;

    // 创建德鲁伊数据源对象
    static DruidDataSource ds = new DruidDataSource();

    // 获取连接信息
    static {
        ResourceBundle br = ResourceBundle.getBundle("druid");
        driveClass = br.getString("driverClass");
        url = br.getString("url");
        username = br.getString("username");
        password = br.getString("password");

        ds.setDriverClassName(driveClass);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setMaxActive(5);
        ds.setMaxWait(3000);
    }

    /**
     * 从连接池中取出一个连接
     *
     * @return
     */
    public static Connection getCon() {
        try {
            con = ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    /**
     * 对 sql 语句预处理
     *
     * @param sql
     * @return
     */
    protected PreparedStatement getPps(String sql) {
        try {
            state = con.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return state;
    }

    /**
     * 对预处理sql语句的参数进行绑定
     * @param params
     */
    private void param(List params) {
        try {
            if (params != null && params.size() > 0) {
                for (int i = 0; i < params.size(); i++) {
                    state.setObject(i + 1, params.get(i));
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增删改
     * @param sql
     * @param params
     * @return
     */
    protected int update(String sql,List params){
        int num = 0;

        try {
            getCon();
            getPps(sql);
            param(params);
            num=state.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }

    /**
     * 数据的查找
     * @param sql
     * @param params
     * @return
     */
    protected ResultSet query(String sql,List params){
        try {
            getCon();
            getPps(sql);
            param(params);
            set = state.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return set;
    }

    /**
     * 关闭连接
     *
     */
    public static void close(){
        try {
            if(con!=null){
                con.close();
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        try {
            if(state!=null) {
                state.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (set!=null) {
                set.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}