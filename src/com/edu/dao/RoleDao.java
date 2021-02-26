package com.edu.dao;

import com.edu.bean.Menu;
import com.edu.bean.Role;

import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-09 21:08
 * @Modified By:
 */
public interface RoleDao {

    /**
     * 获取所有的角色信息
     * @return
     */
    public List<Role> getAllRole();

    /**
     * 启用角色
     * @param roleId
     * @return
     */
    public int EnableRole(int roleId);

    /**
     * 禁用角色
     * @param roleId
     * @return
     */
    public int DisableRole(int roleId);

    /**
     * 删除角色,
     * @param roleId
     * @return
     */
    public boolean deleteRole(int roleId);

    /**
     * 获取角色的id获取角色名和启用状态
     * @param roleId
     * @return
     */
    public Role showRoleMessage(int roleId);

    /**
     * 通过角色的id 获取角色对应的菜单信息
     * @param roleId
     * @return
     */
    public List<Menu> getRoleMenu(int roleId);

    /**
     * 添加角色
     * @param roleName
     * @param roleStatus
     * @param menus
     * @return
     */
    public int addRole(String roleName,int roleStatus,int[] menus);

    /**
     * 修改角色信息
     * @param roleName
     * @param roleStatus
     * @param menus
     * @return
     */
    public int updateRole(String roleName,int roleStatus,int[] menus);
}
