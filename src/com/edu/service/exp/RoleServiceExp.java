package com.edu.service.exp;

import com.edu.bean.Menu;
import com.edu.bean.Role;
import com.edu.dao.RoleDao;
import com.edu.dao.exp.RoleDaoExp;
import com.edu.service.RoleService;

import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-09 21:17
 * @Modified By:
 */
public class RoleServiceExp implements RoleService {
    private RoleDao dao = new RoleDaoExp();
    @Override
    public List<Role> getAllRole() {
        return dao.getAllRole();
    }

    @Override
    public int EnableRole(int roleId) {
        return dao.EnableRole(roleId);
    }

    @Override
    public int DisableRole(int roleId) {
        return dao.DisableRole(roleId);
    }

    @Override
    public boolean deleteRole(int roleId) {
        return dao.deleteRole(roleId);
    }

    @Override
    public Role showRoleMessage(int roleId) {
        return dao.showRoleMessage(roleId);


    }

    @Override
    public List<Menu> getRoleMenu(int roleId) {
        return dao.getRoleMenu(roleId);
    }

    @Override
    public int addRole(String roleName, int roleStatus, int[] menus) {
        return dao.addRole(roleName,roleStatus,menus);
    }

    @Override
    public int updateRole(String roleName, int roleStatus, int[] menus) {
        return dao.updateRole(roleName,roleStatus,menus);
    }
}
