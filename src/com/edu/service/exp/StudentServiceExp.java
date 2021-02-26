package com.edu.service.exp;

import com.edu.bean.Student;
import com.edu.dao.StudentDao;
import com.edu.dao.exp.StudentDaoExp;
import com.edu.service.StudentService;

import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-05 20:07
 * @Modified By:
 */
public class StudentServiceExp implements StudentService {
    private StudentDao dao = new StudentDaoExp();

    @Override
    public List<Student> searchAllStudent(String studentName,String studentNo,int studentSex,int pageIndex,int pageSize) {
        List<Student> list = dao.searchAllStudent(studentName,studentNo,studentSex,pageIndex,pageSize);
        return list;
    }

    @Override
    public int totalNum(String studentName, String studentNo, int studentSex) {
        int total = dao.totalNum(studentName,studentNo,studentSex);
        return total;
    }

    @Override
    public int insertStudent(Student student) {
        return dao.insertStudent(student);
    }

    @Override
    public Student findStudent(int studentId) {
        return dao.findStudent(studentId);
    }

    @Override
    public int updateStudent(Student student) {
        return dao.updateStudent(student);
    }

    @Override
    public int deleteStudent(int studentId) {
        return dao.deleteStudent(studentId);
    }
}
