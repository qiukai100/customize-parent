package com.customize.web.controller;

import com.customize.manage.component.Result;
import com.customize.web.core.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Result login() {

        return Result.success();
    }
}
