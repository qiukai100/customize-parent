package com.customize.manage.service.impl;

import com.customize.manage.core.BaseServiceImpl;
import com.customize.manage.entity.tb.Student;
import com.customize.manage.mapper.StudentMapper;
import com.customize.manage.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StudentServiceImpl extends BaseServiceImpl<Student, String> implements StudentService {

    private final StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public Page<Student> queryStudentPage(Student student, Integer pageNum, Integer pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPage(
                () -> studentMapper.queryStudentPage(student)
        );
    }
}
