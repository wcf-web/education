package com.edu.dao.exp;

import com.edu.bean.Menu;
import com.edu.dao.MenuDao;
import com.edu.util.DruidUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-10 8:46
 * @Modified By:
 */
public class MenuDaoExp extends DruidUtil implements MenuDao {
    @Override
    public List<Menu> getAllMenu() {
        List<Menu> menuList = new ArrayList<>();
        // 1.定义sql
        String sql = "select * from menu where menustatus=1";
        // 2.添加参数
        // 3.执行sql
        try {
            set = query(sql,null);
            while (set.next()){
                Menu menu = new Menu();
                menu.setMenuId(set.getInt("menuid"));
                menu.setMenuName(set.getString("menuname"));
                menu.setMenuStatus(set.getInt("menustatus"));
                menu.setParentId(set.getInt("parentid"));
                menu.setUtl(set.getString("utl"));
                menuList.add(menu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return menuList;
    }

    @Override
    public int addMenu(String menuName, int parentId, String utl, String menustatus, String content) {
        int flag =0;
        // 1. 定义sql
        String sql = "insert into menu(menuname,parentid,utl,menustatus,content) values(?,?,?,?,?)";
        // 2. 添加参数
        List params = new ArrayList();
        params.add(menuName);
        params.add(parentId);
        params.add(utl);
        params.add(menustatus);
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
    public List<Menu> getTopMenu() {
        List<Menu> menus = new ArrayList<>();
        // 1，定义sql
        String sql = "select * from menu where parentid=0 and menustatus=1";
        // 2. 参数
        // 3.执行sql
        try {
            set = query(sql,null);
            while (set.next()){
                Menu menu = new Menu();
                menu.setMenuId(set.getInt("menuid"));
                menu.setMenuName(set.getString("menuname"));
                menus.add(menu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return menus;
    }

    @Override
    public List<Integer> selectMenu(int roleId) {
        List list = new ArrayList();
        // 定义sql
        String sql = "select menuid from role_menu where roleid="+roleId;
        // 执行sql
        try {
            set = query(sql,null);
            while (set.next()){
                list.add(set.getInt("menuid"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return list;
    }

    @Override
    public Menu getMenuById(int menuId) {
        Menu menu = new Menu();
        String sql = "SELECT m2.menuname,m2.utl,m2.menustatus,m2.content,m1.menuid,m1.menuname as parentname\n" +
                "from menu m1,menu m2\n" +
                "where m2.parentid=m1.menuid and m2.menuid="+menuId;
        try {
            set = query(sql,null);
            while (set.next()){
                menu.setMenuName(set.getString("menuname"));
                menu.setParentName(set.getString("parentname"));
                menu.setUtl(set.getString("utl"));
                menu.setMenuStatus(set.getInt("menustatus"));
                menu.setContent(set.getString("content"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return menu;
    }


    @Override
    public int deleteMenu(int menuId) {
        int flag = 0;
        // 1. 定义sql
        String sql = "update menu set menustatus=0 where  menuid=? ";
        // 2. 添加参数
        List params = new ArrayList();
        params.add(menuId);
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









