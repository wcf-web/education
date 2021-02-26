package com.edu.bean;

import java.util.List;

/**
 * @Author: chunfeng
 * @Description: 专业类，专业与学生：一对多
 * @Date Created in  2020-07-06 17:15
 * @Modified By:
 */
public class Major {
    private int majorId;
    private String majorName;
    private List<Student> studentList;
    private College college;
    private List<Classes> classesList;

    public List<Classes> getClassesList() {
        return classesList;
    }

    public void setClassesList(List<Classes> classesList) {
        this.classesList = classesList;
    }

    public Major() {
    }

    public Major(int majorId, String majorName) {
        this.majorId = majorId;
        this.majorName = majorName;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
}
