package com.customize.service.service;

import com.customize.service.core.BaseService;
import com.customize.domain.entity.tb.Student;
import com.github.pagehelper.Page;

public interface StudentService extends BaseService<Student, String> {

    Page<Student> queryStudentPage(Student student, Integer pageNum, Integer pageSize);
}
