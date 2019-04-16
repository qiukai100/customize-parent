package com.customize.mybatis.mapper;

import com.customize.mybatis.core.BaseMapper;
import com.customize.domain.entity.Student;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student, String> {

    List<Student> queryStudentPage(Student student);
}
