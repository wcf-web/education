package com.edu.dao.exp;

import com.edu.bean.Classes;
import com.edu.bean.College;
import com.edu.bean.Major;
import com.edu.bean.Teacher;
import com.edu.dao.ClassDao;
import com.edu.util.DruidUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-07 13:31
 * @Modified By:
 */
public class ClassDaoExp extends DruidUtil implements ClassDao {
    @Override
    public List<Classes> getClassById(int collegeId,int majorId) {
        List<Classes> list = new ArrayList<>();
        String sql = "SELECT * FROM classes WHERE collegeid=? and majorid=? ";
        List params = new ArrayList();
        params.add(collegeId);
        params.add(majorId);
        set = query(sql,params);
        try {
            while (set.next()){
                int classId = set.getInt("classid");
                String className = set.getString("classname");
                list.add(new Classes(classId,className));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return list;
    }

    @Override
    public Classes findClass(int classId) {
        Classes classes = new Classes();
        // 1. 定义sql语句
        String sql = "select  *\n" +
                "from major m,college c,classes e\n" +
                "where  e.majorid=m.majorid and c.collegeid=e.collegeid and classid=? ";
        // 2. 定义参数
        List params = new ArrayList();
        params.add(classId);
        // 3. 执行sql语句
        try {
            set = query(sql,params);
            while (set.next()){
                classes.setClassNo(set.getString("classno"));
                classes.setCollegeName(set.getString("classname"));
                classes.setMajorName(set.getString("majorname"));
                classes.setClassName(set.getString("className"));
                classes.setClassNum(set.getInt("classnum"));
                classes.setStartDate(set.getDate("startdate"));
                classes.setEndDate(set.getDate("enddate"));
                classes.setContent(set.getString("content"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return classes;
    }

    @Override
    public List<Classes> getAllclasses(String className, int pageIndex, int pageSize) {
        List<Classes> list = new ArrayList<>();
        // 1. 定义sql--动态sql
        StringBuffer sql = new StringBuffer("select * \n" +
                "from classes ca,college co,teacher t,major m\n" +
                "where co.collegeid=ca.collegeid and t.teacherid=ca.teacherid and m.majorid=ca.majorid ");
        List params = new ArrayList();
        if(className!=null && className.length()>0){
            sql.append(" and classname like ? ");
            params.add("%"+className+"%");
        }

        //  分页,第一个？表示开始的位置，第二个？表示每页显示的条数
        sql.append(" limit ?,?");
        params.add((pageIndex-1)*pageSize);
        params.add(pageSize);

        try {
            set = query(sql.toString(),params);
            while (set.next()){
                Classes classes = new Classes();
                classes.setClassId(set.getInt("classid"));
                classes.setClassNo(set.getString("classno"));
                classes.setClassName(set.getString("classname"));
                classes.setClassStatus(set.getInt("classstatus"));
                classes.setClassNum(set.getInt("classnum"));
                // 表联结
                Major major = new Major();
                major.setMajorName(set.getString("majorname"));
                classes.setMajor(major);
                Teacher teacher = new Teacher();
                teacher.setTeacherName(set.getString("teachername"));
                classes.setTeacher(teacher);
                list.add(classes);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return list;
    }

    @Override
    public int totalNum(String className) {
        int num = 0;
        // 1.定义sql语句
        StringBuffer sql = new StringBuffer("SELECT count(8) FROM classes WHERE 1=1 ");
        // 2. 定义参数集合
        List params = new ArrayList();
        if(className!=null && className.length()>0){
            sql.append(" and classname like ?");
            params.add("%"+className+"%");
        }
        // 3. 执行sql语句
        try {
            set = query(sql.toString(),params);
            while (set.next()){
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
    public int addClass(String classNo, int collegeId, int majorId, String className, Date startDate, Date endDate, int classNum,int teacherId, String content) {
        int num = 0;
        // 1. 定义sql语句
        StringBuffer sql = new StringBuffer("INSERT into classes(classno,collegeid,majorid,classname,startDate,endDate,classnum,teacherid,content)" +
                "VALUES (?,?,?,?,?,?,?,?,?)");
        // 2. 添加参数
        List params = new ArrayList();
        params.add(classNo);
        params.add(collegeId);
        params.add(majorId);
        params.add(className);
        params.add(startDate);
        params.add(endDate);
        params.add(classNum);
        params.add(teacherId);
        params.add(content);

        // 3. 执行语句
        try {
            num = update(sql.toString(),params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return num;
    }

    @Override
    public List<Classes> auditClass(String classNo,String className) {
        List<Classes> classesList = new ArrayList<>();
        // 1. 定义sql语句
        StringBuffer sql = new StringBuffer("SELECT * " +
                " FROM classes c,college e,teacher t " +
                " where classstatus=1 and c.collegeid=e.collegeid and t.teacherid=c.teacherid");
        // 2. 添加参数
        List params = new ArrayList();
        if(classNo!=null && classNo.length()>0){
            sql.append(" and classno like ? ");
            params.add("%"+classNo+"%");
        }
        if (className!=null && className.length()>0){
            sql.append(" and classname like ? ");
            params.add("%"+className+"%");
        }

        // 3. 执行sql语句
        set = query(sql.toString(),params);
        try {
            while (set.next()){
                Classes classes = new Classes();
                classes.setClassId(set.getInt("classid"));
                classes.setClassNo(set.getString("classno"));
                classes.setClassName(set.getString("classname"));
                classes.setClassNum(Integer.parseInt(set.getString("classnum")));
                // 建立班级与学院、老师的联系
                College college = new College();
                college.setCollegeName(set.getString("collegename"));
                classes.setCollege(college);
                Teacher teacher = new Teacher();
                teacher.setTeacherName(set.getString("teachername"));
                classes.setTeacher(teacher);
                classesList.add(classes);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return classesList;
    }

    @Override
    public int totalNum(String classNo, String className) {
        int num = 0;
        StringBuffer sql = new StringBuffer("SELECT count(*) from classes where classstatus=1 ");
        // 2. 添加查询参数
        List params = new ArrayList();
        if(classNo!=null && classNo.length()>0){
            sql.append(" and classno like ?");
            params.add("%"+classNo+"%");
        }
        if(className!=null && className.length()>0){
            sql.append(" and classname like ?");
            params.add("%"+className+"%");
        }
        // 3.执行sql语句
        try {
            set = query(sql.toString(),params);
            while (set.next()){
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
    public int passClassStatus(int classId) {
        int flag = 0;
        // 1.定义sql语句
        String sql = "UPDATE classes \n" +
                "set classstatus=2 \n" +
                "where classid=? ";
        // 2. 添加参数
        List params = new ArrayList();
        params.add(classId);
        try {
            flag = update(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return flag;
    }

    @Override
    public int rejectClassStatus(int classId) {
        int flag = 0;
        // 1.定义sql语句
        String sql = "UPDATE classes \n" +
                "set classstatus=3 \n" +
                "where classid=? ";
        // 2. 添加参数
        List params = new ArrayList();
        params.add(classId);
        try {
            flag = update(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return flag;
    }

}









