package com.customize.web.controller;

import com.customize.web.core.Result;
import com.customize.domain.entity.sys.Permission;
import com.customize.service.service.PermissionService;
import com.customize.web.core.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("permission")
public class PermissionController extends BaseController {

    private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @RequestMapping(value = "insertMenu", method = RequestMethod.POST)
    public Result insertMenu(Permission permission) {
//        permissionService.save(permission);
        return Result.success();
    }

    @RequestMapping(value = "updateMenu", method = RequestMethod.PUT)
    public Result updateMenu(Permission permission) {
//        permissionService.save(permission);
        return Result.success();
    }

    @RequestMapping(value = "deleteMenu", method = RequestMethod.DELETE)
    public Result deleteMenu(String id) {
//        permissionService.deleteById(id);
        return Result.success();
    }

    @RequestMapping(value = "selectUserMenu", method = RequestMethod.GET)
    public Result selectUserMenu() {
        return Result.success();
    }
}
