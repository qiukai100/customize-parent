package com.customize.manage.mapper;

import com.customize.manage.core.BaseMapper;
import com.customize.manage.entity.tb.Student;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student, String> {

    List<Student> queryStudentPage(Student student);
}
