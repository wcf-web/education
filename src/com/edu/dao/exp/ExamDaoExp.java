package com.edu.dao.exp;

import com.edu.bean.Classes;
import com.edu.bean.Exam;
import com.edu.dao.ExamDao;
import com.edu.util.DruidUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-08 7:45
 * @Modified By:
 */
public class ExamDaoExp extends DruidUtil implements ExamDao {
    @Override
    public List<Exam> getAllExam(String examSubject, int pageIndex, int pageSize) {
        List<Exam> list = new ArrayList<>();
        // 1. 定义sql语句
        StringBuffer sql = new StringBuffer("SELECT  *\n" +
                "FROM exam e,classes c\n" +
                "where e.classid=c.classid ");
        // 2. 添加查询参数
        List params = new ArrayList();
        if(examSubject!=null && examSubject.length()>0){
            sql.append(" and exam_subject like ? ");
            params.add("%"+examSubject+"%");
        }
        // 添加分页参数
        sql.append(" limit ?,? ");
        params.add((pageIndex-1)*pageSize);
        params.add(pageSize);

        // 3.执行sql语句
        set = query(sql.toString(),params);
        try {
            while (set.next()){
                Exam exam = new Exam();
                exam.setExamId(set.getInt("examid"));
                exam.setExamNo(set.getString("exam_no"));
                exam.setExamSubject(set.getString("exam_subject"));
                exam.setExamTime(set.getDate("exam_time"));
                exam.setExamState(set.getInt("exam_state"));
                exam.setExamCount(set.getInt("exam_count"));
                // 将考试与班级建立联系
                Classes classes = new Classes();
                classes.setClassNo(set.getString("classno"));
                exam.setClasses(classes);
                list.add(exam);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return list;
    }

    @Override
    public int totalNum(String examSubject) {
        int num = 0;
        StringBuffer sql = new StringBuffer("SELECT count(*) FROM exam where 1=1 ");
        // 2. 添加查询参数
        List params = new ArrayList();
        if(examSubject!=null && examSubject.length()>0){
            sql.append(" and exam_subject like ?");
            params.add("%"+examSubject+"%");
        }
        // 3.执行sql语句
        try {
            set = query(sql.toString(),params);
            while (set.next()){
                num = set.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return num;
    }

    @Override
    public int addExam(String examNo, String examSubject, Date examTime,int classId, int examCount, int examState) {
        int flag = 0;
        // 1. 定义sql语句
        String sql = "insert into exam(exam_no,exam_subject,exam_time,classid,exam_count,exam_state) values(?,?,?,?,?,?)";
        // 2. 添加参数
        List params = new ArrayList();
        params.add(examNo);
        params.add(examSubject);
        params.add(examTime);
        params.add(classId);
        params.add(examCount);
        params.add(examState);

        // 3. 执行sql语句
        try {
            flag = update(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return flag;
    }

    @Override
    public Exam findExamById(int examId) {
        Exam exam = new Exam();
        // 1. 定义sql语句
        String sql = "select * from exam m,classes c where m.classid=c.classid and examid = ? ";
        // 2. 添加参数
        List params = new ArrayList();
        params.add(examId);
        // 3. 执行sql语句
        try {
            set = query(sql,params);
            while (set.next()){
                exam.setExamId(set.getInt("examid"));
                exam.setExamNo(set.getString("exam_no"));
                exam.setExamSubject(set.getString("exam_subject"));
                exam.setExamTime(set.getDate("exam_time"));
                exam.setExamCount(set.getInt("exam_count"));
                exam.setExamState(set.getInt("exam_state"));
                // 建立考试和班级之间的联系
                Classes classes = new Classes();
                classes.setClassNo(set.getString("classno"));
                exam.setClasses(classes);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return exam;
    }
}








