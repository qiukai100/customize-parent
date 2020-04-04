package com.customize.generator.config;

import com.customize.generator.domain.gen.TemplateInfo;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "generator")
public class GenConfig {
    /**
     * 作者
     */
    private String author;

    /**
     * 分割前缀
     */
    private Boolean splitPrefix = Boolean.TRUE;

    /**
     * 覆盖
     */
    private Boolean cover = Boolean.FALSE;

    /**
     * 前缀数组，用于识别前缀
     */
    private List<String> prefixArray;

    /**
     * 参数
     */
    private Map<String, Object> params;

    /**
     * 模板信息
     */
    private List<TemplateInfo> templateInfos;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getSplitPrefix() {
        return splitPrefix;
    }

    public void setSplitPrefix(Boolean splitPrefix) {
        this.splitPrefix = splitPrefix;
    }

    public Boolean getCover() {
        return cover;
    }

    public void setCover(Boolean cover) {
        this.cover = cover;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public List<TemplateInfo> getTemplateInfos() {
        return templateInfos;
    }

    public void setTemplateInfos(List<TemplateInfo> templateInfos) {
        this.templateInfos = templateInfos;
    }

    public List<String> getPrefixArray() {
        return prefixArray;
    }

    public void setPrefixArray(List<String> prefixArray) {
        this.prefixArray = prefixArray;
    }
}
