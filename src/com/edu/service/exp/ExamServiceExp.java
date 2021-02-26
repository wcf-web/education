package com.edu.service.exp;

import com.edu.bean.Exam;
import com.edu.dao.ExamDao;
import com.edu.dao.exp.ExamDaoExp;
import com.edu.service.ExamService;

import java.util.Date;
import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-08 8:11
 * @Modified By:
 */
public class ExamServiceExp implements ExamService {
    private ExamDao dao = new ExamDaoExp();
    @Override
    public List<Exam> getAllExam(String examSubject, int pageIndex, int pageSize) {
        return dao.getAllExam(examSubject,pageIndex,pageSize);
    }

    @Override
    public int totalNum(String examSubject) {
        return dao.totalNum(examSubject);
    }

    @Override
    public int addExam(String examNo, String examSubject, Date examTime, int classid, int examCount, int examState) {
        return dao.addExam(examNo,examSubject,examTime,classid,examCount,examState);
    }

    @Override
    public Exam findExamById(int examId) {
        return dao.findExamById(examId);
    }
}
