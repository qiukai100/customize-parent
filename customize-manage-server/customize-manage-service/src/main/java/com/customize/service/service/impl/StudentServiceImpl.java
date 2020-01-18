package com.customize.service.service.impl;

import com.customize.service.core.BaseServiceImpl;
import com.customize.domain.entity.tb.Student;
import com.customize.mybatis.mapper.StudentMapper;
import com.customize.service.service.StudentService;
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
