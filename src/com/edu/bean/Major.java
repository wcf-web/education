package com.edu.bean;

import java.util.List;

/**
 * @Desc:  专业类，专业与学生：一对多
 * @Author: chunfeng
 * @Date
 */
public class Major {
    private int majorId;
    private String majorName;
    private List<Student> studentList;
    private College college;
    private List<Class> classList;

    public List<Class> getClassesList() {
        return classList;
    }

    public void setClassesList(List<Class> classList) {
        this.classList = classList;
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
