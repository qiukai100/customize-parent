package com.customize.activity.http.cfsc;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "cfsc")
class ApiConfig {

    private String selectUserList;

    public String getSelectUserList() {
        return selectUserList;
    }

    public void setSelectUserList(String selectUserList) {
        this.selectUserList = selectUserList;
    }
}
