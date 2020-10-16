package com.lu.pojo;

import lombok.Data;

@Data
public class Student {
    private int id;
    private int name;

    // 学生需要关联一个老师
    private Teacher teacher;
}
