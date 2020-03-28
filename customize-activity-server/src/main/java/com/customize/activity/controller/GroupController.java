package com.customize.activity.controller;

import com.customize.common.component.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("group")
public class GroupController {

    private final IdentityService identityService;

    @Autowired
    public GroupController(IdentityService identityService) {
        this.identityService = identityService;
    }

    @GetMapping("selectAllGroup")
    public CommonResult selectAllGroup() {
        List<Group> list = identityService.createGroupQuery().list();
        return CommonResult.success(list);
    }

    @GetMapping("selectGroupByUser")
    public CommonResult selectGroupByUser(@RequestParam String userId) {
        List<Group> list = identityService.createGroupQuery().groupMember(userId).list();
        return CommonResult.success(list);
    }

    @GetMapping("getGroup/{groupId}")
    public CommonResult getGroup(@PathVariable String groupId) {
        Group group = identityService.createGroupQuery().groupId(groupId).singleResult();
        return CommonResult.success(group);
    }
}
