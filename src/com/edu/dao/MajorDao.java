package com.edu.dao;

import com.edu.bean.Major;

import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-06 20:25
 * @Modified By:
 */
public interface MajorDao {

    /**
     * 查询学院的所有的专业
     * @param collegeId
     * @return
     */
    public List<Major> getAllMajor(int collegeId);
}
