package com.edu.dao.exp;

import com.edu.bean.College;
import com.edu.dao.CollegeDao;
import com.edu.util.DruidUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-06 18:40
 * @Modified By:
 */
public class CollegeDaoExp extends DruidUtil implements CollegeDao {
    @Override
    public List<College> getAllCollege() {
        List<College> list = new ArrayList<>();

        String sql = "select * from college";
        set = query(sql,null);

        try {
            while (set.next()) {
                int id = set.getInt(1);
                String name = set.getString(2);
                College college = new College(id,name);
                list.add(college);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return list;
    }
}
