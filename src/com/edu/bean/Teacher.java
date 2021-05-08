package com.edu.bean;

import java.util.List;

/**
 * @Desc:   老师
 * @Author: chunfeng
 * @Date
 */
public class Teacher {
    private int teacherId;
    private String teacherName;
    private List<Class> classList;

    public List<Class> getClassesList() {
        return classList;
    }

    public void setClassesList(List<Class> classList) {
        this.classList = classList;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
