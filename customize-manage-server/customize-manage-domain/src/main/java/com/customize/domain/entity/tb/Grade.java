package com.customize.domain.entity.tb;

import com.customize.domain.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Grade extends BaseEntity {

    private String pkGradeId;

    private String gradeName;

    private Integer level;

}
