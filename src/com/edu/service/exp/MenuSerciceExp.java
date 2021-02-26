package com.edu.service.exp;

import com.edu.bean.Menu;
import com.edu.dao.MenuDao;
import com.edu.dao.exp.MenuDaoExp;
import com.edu.service.MenuService;

import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-10 8:46
 * @Modified By:
 */
public class MenuSerciceExp implements MenuService {
    private MenuDao dao = new MenuDaoExp();
    @Override
    public List<Menu> getAllMenu() {
        return dao.getAllMenu();
    }

    @Override
    public int DeleteMenu(int menuId) {
        return dao.deleteMenu(menuId);
    }

    @Override
    public List<Menu> getTopMenu() {
        return dao.getTopMenu();
    }

    @Override
    public int addMenu(String menuName, int parentId, String utl, String menustatus, String content) {
        return dao.addMenu(menuName,parentId,utl,menustatus,content);
    }

    @Override
    public List<Integer> selectMenu(int roleId) {
        return dao.selectMenu(roleId);
    }

    @Override
    public Menu getMenuById(int menuId) {
        return dao.getMenuById(menuId);
    }
}
