package com.edu.bean;

import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-06 18:38
 * @Modified By:
 */
public class College {
    private int collegeId;
    private String collegeName;
    private List<Major> majors;

    public College() {
    }

    public List<Major> getMajors() {
        return majors;
    }

    public void setMajors(List<Major> majors) {
        this.majors = majors;
    }

    public College(int collegeId, String collegeName) {
        this.collegeId = collegeId;
        this.collegeName = collegeName;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
}
