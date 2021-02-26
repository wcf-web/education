package com.edu.dao;

import com.edu.bean.Menu;

import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-10 8:46
 * @Modified By:
 */
public interface MenuDao {

    /**
     * 获取全部菜单信息
     * @return
     */
    public List<Menu> getAllMenu();

    /**
     * 对菜单进行假删除
     * @param menuId
     * @return
     */
    public int deleteMenu(int menuId);

    /**
     * 添加菜单
     * @param menuName
     * @param parentId
     * @param utl
     * @param menustatus
     * @param content
     * @return
     */
    public int addMenu(String menuName,int parentId,String utl,String menustatus,String content);

    /**
     * 选出所有的顶级菜单
     * @return
     */
    public List<Menu> getTopMenu();

    /**
     * 为不同的角色选择不同的菜单
     * @param roleId
     * @return
     */
    public List<Integer> selectMenu(int roleId);

    /**
     * 通过菜单的id 获取菜单信息
     * @param menuId
     * @return
     */
    public Menu getMenuById(int menuId);
}






