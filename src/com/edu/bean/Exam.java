package com.edu.bean;

import java.util.Date;

/**
 * @Desc:   考试
 * @Author: chunfeng
 * @Date
 */
public class Exam {
    private int examId;
    private int classId;
    private String examNo;
    private String examSubject;
    private Date examTime;
    private int examCount;
    // 1：未考试  2：考试中  3: 已考完
    private int examState;
    private Class aClass;


    public Class getClasses() {
        return aClass;
    }

    public void setClasses(Class aClass) {
        this.aClass = aClass;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getExamNo() {
        return examNo;
    }

    public void setExamNo(String examNo) {
        this.examNo = examNo;
    }

    public String getExamSubject() {
        return examSubject;
    }

    public void setExamSubject(String examSubject) {
        this.examSubject = examSubject;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    public int getExamCount() {
        return examCount;
    }

    public void setExamCount(int examCount) {
        this.examCount = examCount;
    }

    public int getExamState() {
        return examState;
    }

    public void setExamState(int examState) {
        this.examState = examState;
    }
}









