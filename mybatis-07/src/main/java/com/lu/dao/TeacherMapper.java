package com.lu.dao;

import com.lu.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    // 获取老师
    List<Teacher> getTeachers();

    // 获取老师与他学生的信息
    Teacher getTeacherStudent(@Param("tid") int id);
}
