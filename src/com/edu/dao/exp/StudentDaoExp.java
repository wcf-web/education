package com.edu.dao.exp;

import com.edu.bean.Major;
import com.edu.bean.Student;
import com.edu.dao.StudentDao;
import com.edu.util.DruidUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-05 18:05
 * @Modified By:
 */
public class StudentDaoExp extends DruidUtil implements StudentDao {
    @Override
    public List<Student> searchAllStudent(String studentName,String studentNo,int studentSex,int pageIndex,int pageSize) {
        List<Student> list = new ArrayList<>();
        // 1. 定义sql--动态sql
        StringBuffer sql = new StringBuffer("SELECT * FROM student s,major m WHERE stustatus=1 and s.majorid=m.majorid ");
        // 2.定义参数集合
        List params = new ArrayList();
        if(studentName!=null && studentName.length()>0){
            sql.append(" and studentname like ?");
            params.add("%"+studentName+"%");
        }
        if(studentNo!=null && studentNo.length()>0){
            sql.append(" and studentno like ?");
            params.add("%"+studentNo+"%");
        }
        if(studentSex!=-1){
            sql.append(" and sex = ?");
            if(studentSex==1){
                params.add("男");
            }else {
                params.add("女");
            }
        }

        // 第一个？表示开始的位置，第二个？表示每页显示的条数
        sql.append(" limit ?,? ");
        params.add((pageIndex-1)*pageSize);
        params.add(pageSize);

        // 3.调取方法
        set = query(sql.toString(),params);
        // 取出结果集中的内容
        try {
            while (set.next()) {
                Student student = new Student();
                student.setStudentId(set.getInt("studentid"));
                student.setStudentNo(set.getString("studentno"));
                student.setStudentName(set.getString("studentname"));
                student.setSex(set.getString("sex"));
                student.setPhone(set.getString("phone"));
                student.setMajorId(set.getInt("majorId"));
                student.setRegDate(set.getDate("regdate"));
                // 取出专业信息,并赋给学生,建立两者关系
                Major major = new Major();
                major.setMajorName(set.getString("majorname"));
                student.setMajor(major);

                list.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return list;
    }

    @Override
    public int totalNum(String studentName, String studentNo, int studentSex) {
        int num = 0;
        // 1. 定义sql--动态sql
        StringBuffer sql = new StringBuffer("SELECT count(*) FROM student where stustatus=1 and 1=1 ");
        // 2.定义参数集合
        List params = new ArrayList();
        if(studentName!=null && studentName.length()>0){
            sql.append(" and studentname like ?");
            params.add("%"+studentName+"%");
        }
        if(studentNo!=null && studentNo.length()>0){
            sql.append(" and studentno like ?");
            params.add("%"+studentNo+"%");
        }
        if(studentSex!=-1){
            sql.append(" and sex = ?");
            if(studentSex==1){
                params.add("男");
            }else {
                params.add("女");
            }
        }
        // 3.执行sql语句，获取执行结果
        set = query(sql.toString(),params);
        try {
            while(set.next()) {
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
    public int insertStudent(Student student) {
        int num = 0;

        try {
            String sql = "INSERT into student(studentno,studentname,collegeid,majorid,classid,sex,email,phone,register,address,politics,idcard,content) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            List params = new ArrayList();
            params.add(student.getStudentNo());
            params.add(student.getStudentName());
            params.add(student.getCollegeId());
            params.add(student.getMajorId());
            params.add(student.getClassId());
            params.add(student.getSex());
            params.add(student.getEmail());
            params.add(student.getPhone());
            params.add(student.getRegister());
            params.add(student.getAddress());
            params.add(student.getPolitics());
            params.add(student.getIdCard());
            params.add(student.getContent());

            num = update(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return num;
    }

    @Override
    public Student findStudent(int studentId) {
        Student student = new Student();
        String sql = "select * from student s,major m where  s.majorId=m.majorId and studentid=?";
        List params = new ArrayList();
        params.add(studentId);

        set = query(sql,params);
        try {
            while (set.next()){
                student.setStudentId(set.getInt("studentid"));
                student.setStudentNo(set.getString("studentno"));
                student.setStudentName(set.getString("studentname"));
                student.setSex(set.getString("sex"));
                student.setPhone(set.getString("phone"));
                student.setMajorId(set.getInt("majorId"));
                student.setEmail(set.getString("email"));
                student.setRegister(set.getString("register"));
                student.setAddress(set.getString("address"));
                student.setPolitics(set.getString("politics"));
                student.setIdCard(set.getString("idcard"));
                student.setContent(set.getString("content"));
                // 建立学生和专业的关系
                Major major = new Major();
                major.setMajorName(set.getString("majorname"));
                student.setMajor(major);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return student;
    }

    // 只以修改姓名和性别为例，重在实现功能
    @Override
    public int updateStudent(Student student) {
        int num = 0;
        try {
            String sql = "update student set studentname=?,sex=? where studentid=? ";
            List params = new ArrayList();
            params.add(student.getStudentName());
            params.add(student.getSex());
            params.add(student.getStudentId());

            num = update(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return num;
    }

    @Override
    public int deleteStudent(int studentId) {
        int num = 0;
        // stustatus 1表示未删除，0表示已删除
        String sql = "update student set stustatus=0 where studentid="+studentId;

        try {
            num = update(sql,null);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return num;
    }


}
