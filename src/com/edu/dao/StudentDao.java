package com.edu.dao;

import com.edu.bean.Student;

import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-05 17:47
 * @Modified By:
 */
public interface StudentDao {

    /**
     * 对学生进行查询
     * @param studentName 查询的学生姓名
     * @param studentNo 学生学号
     * @param studentSex    学生性别
     * @param pageIndex   页码
     * @param pageSize    每页的条数
     * @return
     */
    public List<Student> searchAllStudent(String studentName,String studentNo,int studentSex,int pageIndex,int pageSize);

    /**
     * 获取查询结果的总条数
     * @return
     */
    public int totalNum(String studentName,String studentNo,int studentSex);

    /**
     * 添加学生
     * @param student
     * @return 返回添加成功的条数
     */
    public int insertStudent(Student student);

    /**
     * 根据学生的id查找学生
     * @param studentId
     * @return
     */
    public Student findStudent(int studentId);

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    public int updateStudent(Student student);

    /**
     * 根据学生id对学生进行假删除
     * @param studentId
     * @return
     */
    public int deleteStudent(int studentId);
}



