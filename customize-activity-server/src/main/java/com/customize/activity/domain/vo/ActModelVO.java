package com.customize.activity.domain.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ActModelVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id; // 模型id

    @NotNull
    private String name; // 模型名称

    @NotNull
    private String key; // 模型标识

    private String description; // 模型描述

    private String category; // 模型分类

    private ActModelVO(@NotNull String name, @NotNull String key, String description) {
        this.name = name;
        this.key = key;
        this.description = description;
    }

    public ActModelVO() {
    }

    public static ActModelVO getDefaultModel() {
        return new ActModelVO("new-process", "process", "默认的流程模型");
    }
}
