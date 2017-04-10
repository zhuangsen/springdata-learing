package com.zs.dao;


import com.zs.domain.Student;

import java.util.List;

public interface StudentDao {

    /**
     * 查询所有学生
     *
     * @return 所有学生
     */
    public List<Student> query();

    /**
     * 添加一个学生
     *
     * @param student 待添加的学生
     */
    public void save(Student student);
}
