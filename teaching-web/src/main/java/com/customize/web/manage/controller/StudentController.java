package com.customize.web.manage.controller;

import com.customize.common.utils.RandomUtil;
import com.customize.common.utils.UUIDUtil;
import com.customize.common.utils.VerifyUtil;
import com.customize.domain.vo.StudentVo;
import com.customize.feign.service.hbase.PictureFeignService;
import com.customize.web.core.BaseController;
import com.customize.component.modules.Result;
import com.customize.domain.entity.Student;
import com.customize.service.service.StudentService;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ResponseBody
    @RequestMapping(value = "queryStudentPage", method = RequestMethod.GET)
    public Result queryStudentPage(StudentVo student,
                                   @RequestParam(defaultValue = "0") Integer pageNum, @RequestParam(defaultValue = "20") Integer pageSize) {
        Page<Student> list = studentService.queryStudentPage(student, pageNum, pageSize);
        return Result.success(list);
    }

    @ResponseBody
    @RequestMapping(value = "selectAll", method = RequestMethod.GET)
    public Result selectAll() {
        List<Student> list = studentService.selectAll();
        return Result.success(list);
    }

    @ResponseBody
    @RequestMapping(value = "addStudent", method = RequestMethod.POST)
    public Result addStudent(StudentVo student) {
        student.setPkStuId(UUIDUtil.randomUUID());
        student.setStuNo(RandomUtil.randomNo());
        String vailMsg = VerifyUtil.verifyEntity(student);
        if (!VerifyUtil.vailIsPass(vailMsg)) {
            return Result.error(vailMsg);
        }
        pictureFeignService.uploadPicture("tb_student", student.getPkStuId(), "pic", student.getPhotoFile());
//        studentService.save(student);
        return Result.success();
    }

    @ResponseBody
    @RequestMapping(value = "setStudent", method = RequestMethod.POST)
    public Result setStudent(StudentVo student) {
        return Result.success();
    }

    @ResponseBody
    @RequestMapping(value = "delStudent/{pkStuId}", method = RequestMethod.POST)
    public Result delStudent(@PathVariable("pkStuId") String pkStuId) {
        return Result.success();
    }

    @ResponseBody
    @RequestMapping(value = "delStudents", method = RequestMethod.POST)
    public Result delStudents(String[] pkStuIds) {
        return Result.success();
    }
}
