package com.edu.bean;

import java.util.Date;

/**
 * @Desc:   学生
 * @Author: chunfeng
 * @Date
 */
public class Student {
    private int studentId;
    private String studentNo;
    private String studentName;
    private int collegeId;
    private int classId;
    private String sex;
    private String email;
    private String register;
    private String address;
    private String politics;
    private String idCard;
    private String content;
    private int majorId;
    private Date regDate;
    private String phone;
    private Major major;

    public Student(String studentNo, String studentName, int collegeId, int majorId, int classId, String sex, String email, String phone, String register, String address, String politics, String idCard, String content) {
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.collegeId = collegeId;
        this.classId = classId;
        this.sex = sex;
        this.email = email;
        this.register = register;
        this.address = address;
        this.politics = politics;
        this.idCard = idCard;
        this.content = content;
        this.majorId = majorId;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNo='" + studentNo + '\'' +
                ", studentName='" + studentName + '\'' +
                ", collegeId=" + collegeId +
                ", classId=" + classId +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", register='" + register + '\'' +
                ", address='" + address + '\'' +
                ", politics='" + politics + '\'' +
                ", idCard='" + idCard + '\'' +
                ", content='" + content + '\'' +
                ", majorId=" + majorId +
                ", regDate=" + regDate +
                ", phone='" + phone + '\'' +
                ", major=" + major +
                '}';
    }

    public Student() {
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentid) {
        this.studentId = studentid;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
