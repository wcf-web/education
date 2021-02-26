package com.edu.service;

import com.edu.bean.Classes;

import java.util.Date;
import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-07 15:18
 * @Modified By:
 */
public interface ClassService {

    /**
     * 根据学院id和专业id查找班级
     * @param majorId
     * @return
     */
    public List<Classes> getClassById(int collegeId, int majorId);

    /**
     * 获取班级信息
     * @param className
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<Classes> getAllclasses(String className,int pageIndex,int pageSize);

    /**
     * 获取班级信息的总条数
     * @param className
     * @return
     */
    public int totalNum(String className);

    /**
     * 添加班级
     * @param classNo
     * @param collegeId
     * @param majorId
     * @param className
     * @param startDate
     * @param endDate
     * @param teacherId
     * @param content
     * @return
     */
    public int addClass(String classNo, int collegeId, int majorId, String className, Date startDate, Date endDate, int classNUm,int teacherId, String content);

    /**
     * 根据class的id寻找班级
     * @param classId
     * @return
     */
    public Classes findClass(int classId);

    /**
     * 获取待审核的班级
     * @return
     */
    public List<Classes> auditClass(String classNo,String className);

    /**
     * 获取待审核班级的总条数
     * @param classNo
     * @param className
     * @return
     */
    public int totalNum(String classNo,String className);

    /**
     * 通过班级的审核请求
     * @param classId
     * @return
     */
    public int passClassStatus(int classId);

    /**
     * 驳回班级的审核请求
     * @param classId
     * @return
     */
    public int rejectClassStatus(int classId);
}
