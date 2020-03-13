package com.customize.activity.activiti.utils;

import com.customize.common.utils.system.UUIDUtil;

public class IdGenerator implements org.activiti.engine.impl.cfg.IdGenerator {

    @Override
    public String getNextId() {
        return UUIDUtil.randomUUID();
    }
}
