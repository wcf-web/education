package com.edu.service;

import com.edu.bean.Student;

import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-05 17:48
 * @Modified By:
 */
public interface StudentService {
    /**
     * 获取查询到的学生的信息
     * @return
     */
    public List<Student> searchAllStudent(String studentNanme,String studentNo,int studentSex,int pageIndex,int pageSize);

    /**
     * 获取查询结果的总条数
     * @return
     */
    public int totalNum(String studentName,String studentNo,int studentSex);

    /**
     * 添加学生
     * @param student
     * @return
     */
    public int insertStudent(Student student);

    /**
     * 根据学生的id查找学生
     * @param studentId
     * @return
     */
    public Student findStudent(int studentId);

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    public int updateStudent(Student student);

    /**
     * 假删除
     * @param studentId
     * @return
     */
    public int deleteStudent(int studentId);
}
