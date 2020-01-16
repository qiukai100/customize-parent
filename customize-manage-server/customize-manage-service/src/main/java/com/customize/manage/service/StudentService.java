package com.customize.manage.service;

import com.customize.manage.core.BaseService;
import com.customize.manage.entity.tb.Student;
import com.github.pagehelper.Page;

public interface StudentService extends BaseService<Student, String> {

    Page<Student> queryStudentPage(Student student, Integer pageNum, Integer pageSize);
}
