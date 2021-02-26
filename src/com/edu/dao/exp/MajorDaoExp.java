package com.edu.dao.exp;

import com.edu.bean.Major;
import com.edu.dao.MajorDao;
import com.edu.util.DruidUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-06 20:27
 * @Modified By:
 */
public class MajorDaoExp extends DruidUtil implements MajorDao {

    @Override
    public List<Major> getAllMajor(int collegeId) {
        List<Major> list = new ArrayList<>();
        String sql = "SELECT * FROM major WHERE collegeid=? ";
        List params = new ArrayList();
        params.add(collegeId);
        set = query(sql,params);
        try {
            while (set.next()){
                int majorId = set.getInt("majorid");
                String majorName = set.getString("majorname");
                list.add(new Major(majorId,majorName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return list;
    }
}





