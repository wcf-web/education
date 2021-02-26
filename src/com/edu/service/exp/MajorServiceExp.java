package com.edu.service.exp;

import com.edu.bean.Major;
import com.edu.dao.MajorDao;
import com.edu.dao.exp.MajorDaoExp;
import com.edu.service.MajorService;

import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-06 20:40
 * @Modified By:
 */
public class MajorServiceExp implements MajorService {
    private MajorDao dao = new MajorDaoExp();
    @Override
    public List<Major> getAllMajor(int collegeId) {
        return dao.getAllMajor(collegeId);
    }
}
