package com.edu.dao;

import com.edu.bean.College;

import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-06 18:40
 * @Modified By:
 */
public interface CollegeDao {

    /**
     * 获取所有的学院
     * @return
     */
    public List<College> getAllCollege();
}
