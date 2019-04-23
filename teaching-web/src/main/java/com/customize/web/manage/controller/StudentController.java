package com.customize.web.manage.controller;

import cn.hutool.core.codec.Base64Decoder;
import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.core.img.Img;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.util.ImageUtil;
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

import java.io.IOException;

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

    @RequestMapping(value = "addStudent", method = RequestMethod.POST)
    public Result addStudent(Student student, MultipartFile photoFile) {
        student.setPkStuId(UUIDUtil.randomUUID());
        student.setStuNo(RandomUtil.randomNo());
        String vailMsg = VerifyUtil.verifyEntity(student);
        if (!VerifyUtil.vailIsPass(vailMsg) || photoFile == null) {
            return Result.error(vailMsg);
        }
        String fileName = photoFile.getOriginalFilename();
        String fileType;
        if (fileName == null) {
            fileType = ImgUtil.IMAGE_TYPE_JPG;
        } else {
            fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        JSONObject jsonObject;
        try {
            byte[] bytes = photoFile.getBytes();
            String file = Base64Encoder.encode(bytes);
            jsonObject = pictureFeignService.uploadPictureMini("tb_student", student.getPkStuId(), fileType, file);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error();
        }
        if (jsonObject == null) {
            return Result.error();
        }
        log.debug("pictureFeignService uploadPicture is end. result is {}", jsonObject);
        HBaseResult hBaseResult = JsonResultUtil.jsonToBean(jsonObject, HBaseResult.class);
        if (hBaseResult.isSuccess()) {
            log.debug("file path is {}", hBaseResult.getData());
            student.setPicUrl(hBaseResult.getData().toString());
            student.setCreateId("");
            studentService.save(student);
            return Result.success();
        }
        return Result.error();
    }

}
