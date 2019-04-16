package com.customize.test;

import com.customize.redis.server.RedisServer;
import com.customize.web.WebApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestController {

    @LocalServerPort
    private int port;

    private URL base;

    private String devPath = "/dev/teaching";

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RedisServer redisServer;

    @Before
    public void before() throws MalformedURLException {
        String url = "http://127.0.0.1:".concat(String.valueOf(port)).concat(devPath);
        this.base = new URL(url);
    }

    @Test
    public void testService() {
        ResponseEntity<String> response = this.restTemplate.getForEntity(
                this.base.toString() + "/manage/student/selectAll", String.class, "");
        log.debug("response is {}", response);
    }

    @Test
    public void testMain() {
        redisServer.remove("test");
        redisServer.set("test", "aaa");
        log.debug("redis get test is {}", redisServer.get("test"));
    }
}
