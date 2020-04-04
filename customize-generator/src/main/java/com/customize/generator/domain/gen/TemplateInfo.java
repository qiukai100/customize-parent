package com.customize.generator.domain.gen;

import com.customize.generator.constants.TempTypeEnum;

public class TemplateInfo {

    private TempTypeEnum typeEnum;

    private String vmPath;

    private String fileDirectory;

    private Boolean autoCompletion = Boolean.TRUE;

    public TempTypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(TempTypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    public String getVmPath() {
        return vmPath;
    }

    public void setVmPath(String vmPath) {
        this.vmPath = vmPath;
    }

    public String getFileDirectory() {
        return fileDirectory;
    }

    public void setFileDirectory(String fileDirectory) {
        this.fileDirectory = fileDirectory;
    }

    public Boolean getAutoCompletion() {
        return autoCompletion;
    }

    public void setAutoCompletion(Boolean autoCompletion) {
        this.autoCompletion = autoCompletion;
    }
}
