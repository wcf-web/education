package com.edu.service.exp;

import com.edu.bean.College;
import com.edu.dao.CollegeDao;
import com.edu.dao.exp.CollegeDaoExp;
import com.edu.service.CollegeService;

import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-06 18:52
 * @Modified By:
 */
public class CollegeServiceExp implements CollegeService {
    private CollegeDao dao = new CollegeDaoExp();
    @Override
    public List<College> getAllCollege() {
        return dao.getAllCollege();
    }
}
