package com.edu.service;

import com.edu.bean.Major;

import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-06 20:40
 * @Modified By:
 */
public interface MajorService {
    /**
     * 查询学院的所有的专业
     * @param collegeId
     * @return
     */
    public List<Major> getAllMajor(int collegeId);
}
