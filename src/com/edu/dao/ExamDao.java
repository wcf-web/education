package com.edu.dao;

import com.edu.bean.Exam;

import java.util.Date;
import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-08 7:43
 * @Modified By:
 */
public interface ExamDao {

    /**
     * 根据考试科目和分页信息，获取考试信息
     * @param examSubject
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<Exam> getAllExam(String examSubject,int pageIndex,int pageSize);

    /**
     * 根据考试科目查询总条数
     * @param examSubject
     * @return
     */
    public int totalNum(String examSubject);

    /**
     * 添加考试
     * @param examNo
     * @param examSubject
     * @param examTime
     * @param examCount
     * @param examState
     * @return
     */
    public int addExam(String examNo, String examSubject, Date examTime,int classid,int examCount,int examState);

    /**
     * 根据考试的id获取考试信息
     * @param examId
     * @return
     */
    public Exam findExamById(int examId);
}
