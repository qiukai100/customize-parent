package com.customize.manage.entity.tb;

import com.customize.manage.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Grade extends BaseEntity {

    private String pkGradeId;

    private String gradeName;

    private Integer level;

}
