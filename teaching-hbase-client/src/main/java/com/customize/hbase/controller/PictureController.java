package com.customize.hbase.controller;

import com.customize.hbase.service.HBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("picture")
public class PictureController {

    private final HBaseService hBaseService;

    @Autowired
    public PictureController(HBaseService hBaseService) {
        this.hBaseService = hBaseService;
    }

    @ResponseBody
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public void test() {
        hBaseService.deleteTable("test_base");
    }
}
