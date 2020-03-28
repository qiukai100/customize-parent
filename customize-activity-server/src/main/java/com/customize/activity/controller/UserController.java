package com.customize.activity.controller;

import com.customize.common.component.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    private final IdentityService identityService;

    @Autowired
    public UserController(IdentityService identityService) {
        this.identityService = identityService;
    }

    @GetMapping("selectAllUser")
    public CommonResult selectAllUser() {
        List<User> list = identityService.createUserQuery().list();
        return CommonResult.success(list);
    }

    @GetMapping("selectUserByGroup")
    public CommonResult selectUserByGroup(@RequestParam String groupId) {
        List<User> list = identityService.createUserQuery().memberOfGroup(groupId).list();
        return CommonResult.success(list);
    }

    @GetMapping("getUser/{userId}")
    public CommonResult getUser(@PathVariable String userId) {
        User user = identityService.createUserQuery().userId(userId).singleResult();
        return CommonResult.success(user);
    }

    @PostMapping("initUser")
    public CommonResult initUser() {
        Group group1 = identityService.newGroup("group1");
        group1.setName("员工组");
        group1.setType("员工组");
        identityService.saveGroup(group1);

        Group group2 = identityService.newGroup("group2");
        group2.setName("总监组");
        group2.setType("总监阻");
        identityService.saveGroup(group2);

        Group group3 = identityService.newGroup("group3");
        group3.setName("经理组");
        group3.setType("经理组");
        identityService.saveGroup(group3);

        Group group4 = identityService.newGroup("group4");
        group4.setName("人力资源组");
        group4.setType("人力资源组");
        identityService.saveGroup(group4);

        User user1 = identityService.newUser("user1");
        user1.setFirstName("张三");
        user1.setLastName("张");
        user1.setPassword("123456");
        user1.setEmail("zhangsan@qq.com");
        identityService.saveUser(user1);
        identityService.createMembership(user1.getId(), group1.getId());

        User user2 = identityService.newUser("user2");
        user2.setFirstName("李四");
        user2.setLastName("李");
        user2.setPassword("123456");
        user2.setEmail("lisi@qq.com");
        identityService.saveUser(user2);
        identityService.createMembership(user2.getId(), group2.getId());

        User user3 = identityService.newUser("user3");
        user3.setFirstName("王五");
        user3.setLastName("王");
        user3.setPassword("123456");
        user3.setEmail("wangwu@qq.com");
        identityService.saveUser(user3);
        identityService.createMembership(user3.getId(), group3.getId());

        User user4 = identityService.newUser("user4");
        user4.setFirstName("吴六");
        user4.setLastName("吴");
        user4.setPassword("123456");
        user4.setEmail("wuliu@qq.com");
        identityService.saveUser(user4);
        identityService.createMembership(user4.getId(), group4.getId());
        return CommonResult.success();
    }
}
