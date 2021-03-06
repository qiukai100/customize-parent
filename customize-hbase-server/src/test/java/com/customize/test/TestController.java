package com.customize.test;

import com.customize.hbase.HBaseApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HBaseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestController {

    @LocalServerPort
    private int port;

    private URL base;

    private String devPath = "/customize/hbase";

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void before() throws MalformedURLException {
        String url = "http://127.0.0.1:".concat(String.valueOf(port)).concat(devPath);
        this.base = new URL(url);
    }

    @Test
    public void testService() {

    }
}
