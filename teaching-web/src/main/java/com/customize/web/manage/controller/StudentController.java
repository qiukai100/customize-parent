package com.customize.web.manage.controller;

import com.alibaba.fastjson.JSONObject;
import com.customize.common.utils.system.RandomUtil;
import com.customize.common.utils.system.UUIDUtil;
import com.customize.common.utils.system.VerifyUtil;
import com.customize.feign.modules.HBaseResult;
import com.customize.feign.utils.JsonResultUtil;
import com.customize.web.core.BaseController;
import com.customize.component.modules.Result;
import com.customize.domain.entity.tb.Student;
import com.customize.service.service.StudentService;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("manage/student")
public class StudentController extends BaseController {
    private final StudentService studentService;

    @Autowired
    private StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "queryStudentPage", method = RequestMethod.GET)
    public Result queryStudentPage(Student student,
                                   @RequestParam(defaultValue = "0") Integer pageNum, @RequestParam(defaultValue = "20") Integer pageSize) {
        Page<Student> list = studentService.queryStudentPage(student, pageNum, pageSize);
        return Result.success(list);
    }

    @RequestMapping(value = "addStudent", method = RequestMethod.POST)
    public Result addStudent(Student student, MultipartFile photoFile) {
        student.setPkStuId(UUIDUtil.randomUUID());
        student.setStuNo(RandomUtil.randomNo());
        String vailMsg = VerifyUtil.verifyEntity(student);
        if (!VerifyUtil.vailIsPass(vailMsg) || photoFile == null) {
            return Result.error(vailMsg);
        }
        try {
            JSONObject jsonObject = this.uploadPicture("tb_student", student.getPkStuId(), photoFile);
            log.debug("pictureFeignService uploadPicture is end. result is {}", jsonObject);
            HBaseResult hBaseResult = JsonResultUtil.jsonToBean(jsonObject, HBaseResult.class);
            if (hBaseResult.isSuccess()) {
                log.debug("file path is {}", hBaseResult.getData());
                student.setPicUrl(hBaseResult.getData().toString());
                student.setCreateId("");
                studentService.save(student);
                return Result.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.error();
    }

}
