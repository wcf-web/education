package com.edu.dao.exp;

import com.edu.bean.Menu;
import com.edu.bean.Role;
import com.edu.dao.RoleDao;
import com.edu.util.DruidUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-09 21:10
 * @Modified By:
 */
public class RoleDaoExp extends DruidUtil implements RoleDao {
    @Override
    public List<Role> getAllRole() {
        List<Role> roleList = new ArrayList<>();
        // 1.定义sql
        String sql = "select * from role where exist=1";
        // 2. 参数
        // 3. 执行sql
        try {
            set = query(sql,null);
            while (set.next()){
                Role role = new Role();
                role.setRoleId(set.getInt("roleid"));
                role.setRoleName(set.getString("rolename"));
                role.setRoleStatus(set.getInt("rolestatus"));
                roleList.add(role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return roleList;
    }

    @Override
    public int EnableRole(int roleId) {
        int flag = 0;
        String sql = "update role set rolestatus=1 where roleid=? ";
        List params = new ArrayList();
        params.add(roleId);
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
    public int DisableRole(int roleId) {
        int flag = 0;
        String sql = "update role set rolestatus=0 where roleid=? ";
        List params = new ArrayList();
        params.add(roleId);
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
    public boolean deleteRole(int roleId) {
        // 在删除前，先判断该角色下 还有没有用户。若有，则不能删除
        int num = 0;
        String sql = "select count(*) from user where userstatus=1 and roleid="+roleId;
        try {
            set = query(sql,null);
            while (set.next()){
                num = set.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        if(num!=0){
            return false;
        }

        sql = "update role set exist=0 where roleid="+roleId;
        try {
            num=update(sql,null);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return num>0;
    }

    @Override
    public Role showRoleMessage(int roleId) {
        Role role = new Role();
        String sql = "select rolename,rolestatus from role where roleid="+roleId;
        try {
            set = query(sql,null);
            while (set.next()){
                role.setRoleName(set.getString("rolename"));
                role.setRoleStatus(set.getInt("rolestatus"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return role;
    }

    @Override
    public List<Menu> getRoleMenu(int roleId) {
        List list = new ArrayList();
        String sql = "select m.menuname,m.menuid,parentid\n" +
                "from menu m,role_menu r\n" +
                "where m.menuid=r.menuid and roleid="+roleId;
        try {
            set = query(sql,null);
            while (set.next()){
                Menu menu = new Menu();
                menu.setMenuId(set.getInt("menuid"));
                menu.setMenuName(set.getString("menuname"));
                menu.setParentId(set.getInt("parentid"));
                list.add(menu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return list;
    }

    @Override
    public int addRole(String roleName, int roleStatus, int[] menus) {
        int flag1 = 0;
        String sql1 = "insert into role(rolename,rolestatus) values(?,?)";
        List param1 = new ArrayList();
        param1.add(roleName);
        param1.add(roleStatus);
        try {
            flag1 = update(sql1,param1);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }

        String sql2 = "select roleid from role where rolename like ?";
        List param3 = new ArrayList();
        param3.add("%"+roleName+"%");
        int roleId = 0;
        try {
            set = query(sql2,param3);
            while (set.next()){
                roleId = set.getInt("roleid");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }

        String sql3 = "insert into role_menu(roleid,menuid) values(?,?)";
        for (int i=0;i<menus.length;i++){
            List param2 = new ArrayList();
            param2.add(roleId);
            param2.add(menus[i]);
            try {
                update(sql3,param2);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                close();
            }
        }
        return flag1;
    }


    @Override
    public int updateRole(String roleName, int roleStatus, int[] menus) {
        int flag = 0;
        String sql1 = "select roleid from role where rolename like ?";
        List param3 = new ArrayList();
        param3.add("%"+roleName+"%");
        int roleId = 0;
        try {
            set = query(sql1,param3);
            while (set.next()){
                roleId = set.getInt("roleid");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }

        //删除所有关于id为roleId的角色菜单
        String sql2 = "delete from role_menu where roleid="+roleId;
        try {
            update(sql2,null);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }


        String sql3 = "insert into role_menu(roleid,menuid) values(?,?)";
        for (int i=0;i<menus.length;i++){
            List param2 = new ArrayList();
            param2.add(roleId);
            param2.add(menus[i]);
            try {
                flag = update(sql3,param2);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                close();
            }
        }

        return flag;
    }
}




