package com.customize.web.manage.controller;

import com.alibaba.fastjson.JSONObject;
import com.customize.common.utils.RandomUtil;
import com.customize.common.utils.UUIDUtil;
import com.customize.common.utils.VerifyUtil;
import com.customize.domain.vo.StudentVo;
import com.customize.feign.modules.HBaseResult;
import com.customize.feign.service.hbase.PictureFeignService;
import com.customize.feign.utils.JsonResultUtil;
import com.customize.web.core.BaseController;
import com.customize.component.modules.Result;
import com.customize.domain.entity.Student;
import com.customize.service.service.StudentService;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("manage/student")
public class StudentController extends BaseController {
    private final StudentService studentService;

    private final PictureFeignService pictureFeignService;

    @Autowired
    private StudentController(StudentService studentService, PictureFeignService pictureFeignService) {
        this.studentService = studentService;
        this.pictureFeignService = pictureFeignService;
    }

    @RequestMapping(value = "queryStudentPage", method = RequestMethod.GET)
    public Result queryStudentPage(StudentVo student,
                                   @RequestParam(defaultValue = "0") Integer pageNum, @RequestParam(defaultValue = "20") Integer pageSize) {
        Page<Student> list = studentService.queryStudentPage(student, pageNum, pageSize);
        return Result.success(list);
    }

    @RequestMapping(value = "selectAll", method = RequestMethod.GET)
    public Result selectAll() {
        List<Student> list = studentService.selectAll();
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
        JSONObject jsonObject = pictureFeignService.uploadPicture("tb_student", student.getPkStuId(), "pic", photoFile);
        log.debug("pictureFeignService uploadPicture is end. result is {}", jsonObject);
        HBaseResult hBaseResult = JsonResultUtil.jsonToBean(jsonObject, HBaseResult.class);
        if (hBaseResult.isSuccess()) {
            log.debug("file path is {}", hBaseResult.getData());
            student.setPicUrl(hBaseResult.getData().toString());
            student.setCreateId("");
            studentService.save(student);
        }
        return Result.error();
    }

    @RequestMapping(value = "testConn", method = RequestMethod.POST)
    public Result testConn(int connTime) {
        long startTime = System.currentTimeMillis();
        JSONObject jsonObject = pictureFeignService.testConn(connTime);
        long endTime = System.currentTimeMillis();
        HBaseResult hBaseResult = JsonResultUtil.jsonToBean(jsonObject, HBaseResult.class);
        if (hBaseResult.isSuccess()) {
            return Result.success("结果：".concat(hBaseResult.getMessage()).concat("所用毫秒：").concat(String.valueOf(endTime - startTime)).concat("ms"));
        }
        return Result.error("结果：".concat(hBaseResult.getMessage()).concat("所用毫秒：").concat(String.valueOf(endTime - startTime)).concat("ms"));
    }

    @RequestMapping(value = "setStudent", method = RequestMethod.POST)
    public Result setStudent(StudentVo student) {
        return Result.success();
    }

    @RequestMapping(value = "delStudent/{pkStuId}", method = RequestMethod.POST)
    public Result delStudent(@PathVariable("pkStuId") String pkStuId) {
        return Result.success();
    }

    @RequestMapping(value = "delStudents", method = RequestMethod.POST)
    public Result delStudents(String[] pkStuIds) {
        return Result.success();
    }
}
