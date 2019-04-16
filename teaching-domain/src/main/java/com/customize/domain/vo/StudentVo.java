package com.customize.domain.vo;

import com.customize.common.annotations.CustVerify;
import com.customize.domain.entity.Student;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class StudentVo extends Student {

    @CustVerify
    private MultipartFile photoFile;

}
