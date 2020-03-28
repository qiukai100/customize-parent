package com.customize.activity.service;

import java.io.OutputStream;

public interface ProcessService {

    /**
     * 获取已流转的流程图
     *
     * @param processInstanceId 流程实例ID
     * @param outputStream 输出流
     */
    void getFlowImgByInstanceId(String processInstanceId, OutputStream outputStream);
}
