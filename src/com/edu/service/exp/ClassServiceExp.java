package com.edu.service.exp;

import com.edu.bean.Classes;
import com.edu.dao.ClassDao;
import com.edu.dao.exp.ClassDaoExp;
import com.edu.service.ClassService;

import java.util.Date;
import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-07 15:19
 * @Modified By:
 */
public class ClassServiceExp implements ClassService {
    private ClassDao dao = new ClassDaoExp();
    @Override
    public List<Classes> getClassById(int collegeId, int majorId) {
        return dao.getClassById(collegeId,majorId);
    }

    @Override
    public List<Classes> getAllclasses(String className, int pageIndex, int pageSize) {
        return dao.getAllclasses(className,pageIndex,pageSize);
    }

    @Override
    public int totalNum(String className) {
        return dao.totalNum(className);
    }

    @Override
    public int addClass(String classNo, int collegeId, int majorId, String className, Date startDate, Date endDate, int classNum,int teacherId, String content) {
        return dao.addClass(classNo,collegeId,majorId,className,startDate,endDate,classNum,teacherId,content);
    }

    @Override
    public Classes findClass(int classId) {
        return dao.findClass(classId);
    }

    @Override
    public List<Classes> auditClass(String classNo,String className) {
        return dao.auditClass(classNo,className);
    }

    @Override
    public int totalNum(String classNo, String className) {
        return dao.totalNum(classNo,className);
    }

    @Override
    public int passClassStatus(int classId) {
        return dao.passClassStatus(classId);
    }

    @Override
    public int rejectClassStatus(int classId) {
        return dao.rejectClassStatus(classId);
    }

}
