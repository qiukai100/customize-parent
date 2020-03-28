package com.customize.activity.http.cfsc;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

@Slf4j
//@Component
public class HttpClient {
    private final ApiConfig apiConfig;
    private final RestTemplate restTemplate;

    @Autowired
    public HttpClient(ApiConfig apiConfig, RestTemplate restTemplate) {
        this.apiConfig = apiConfig;
        this.restTemplate = restTemplate;
    }

    public String selectAllUser(String userId) {
        Map<String, String> params = Maps.newHashMap();
        params.put("userId", userId);
        try {
            return sendGet(apiConfig.getSelectUserList(), params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String sendPost(String url, MultiValueMap<String, ?> params)
            throws Exception {
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(new URI(url), params, String.class);
        return responseEntity.getBody();
    }

    private String sendGet(String url, Map<String, ?> params)
            throws Exception {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, params);
        return responseEntity.getBody();
    }
}
