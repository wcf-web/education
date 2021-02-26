package com.edu.service;

import com.edu.bean.College;

import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-06 18:51
 * @Modified By:
 */
public interface CollegeService {
    /**
     * 获取所有的学院
     * @return
     */
    public List<College> getAllCollege();
}
