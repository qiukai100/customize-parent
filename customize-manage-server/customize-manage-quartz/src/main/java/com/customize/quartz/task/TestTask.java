package com.customize.quartz.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("TestTask")
public class TestTask {

    public void testJob() {
        System.out.println("testJob is run. =========================");
    }

    public void testJob2() {
        System.out.println("testJob2 is run. =========================");
    }
}
