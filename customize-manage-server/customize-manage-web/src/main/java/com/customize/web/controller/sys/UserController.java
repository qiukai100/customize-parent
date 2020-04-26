package com.customize.web.controller.sys;

import com.customize.web.core.BaseController;
import com.customize.web.core.Result;
import com.customize.domain.vo.sys.UserVo;
import com.customize.domain.dto.sys.UserDto;
import com.customize.service.service.sys.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.customize.web.core.Result.success;

/**
 * @author qiukai
 * @date 2020-04-26
 */
@Slf4j
@RestController
@RequestMapping("sys/user")
@Api(value = "sys/user", description  = "用户管理接口")
public class UserController extends BaseController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) throws Exception {
        this.userService = userService;
    }

    @ApiOperation("分页条件查询用户")
    @RequestMapping(method = RequestMethod.GET, value = "queryUserPage")
    public Result queryUserPage(UserVo userVo) throws Exception {
        return success(userService.queryUserPage(userVo));
    }

    @ApiOperation("条件查询用户")
    @RequestMapping(method = RequestMethod.GET, value = "queryUserList")
    public Result queryUserList(UserVo userVo) throws Exception {
        return success(userService.queryUserList(userVo));
    }

    @ApiOperation("查询所有用户")
    @RequestMapping(method = RequestMethod.GET, value = "selectUserList")
    public Result selectUserList() throws Exception {
        return success(userService.selectUserList());
    }

    @ApiOperation("根据ID查询用户")
    @RequestMapping(method = RequestMethod.GET, value = "findUserById/{pkUserId}")
    public Result findById(@PathVariable("pkUserId") String pkUserId) {
        return success(userService.findById(pkUserId));
    }

    @ApiOperation("新增用户")
    @RequestMapping(method = RequestMethod.POST, value = "insertUser")
    public Result insertUser(UserDto userDto) throws Exception {
        return success(userService.insertSelective(userDto));
    }

    @ApiOperation("修改用户")
    @RequestMapping(method = RequestMethod.PUT, value = "updateUser")
    public Result updateUser(UserDto userDto) throws Exception {
        return success(userService.updateByPrimaryKeySelective(userDto));
    }

    @ApiOperation("根据ID移除用户（逻辑删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "removeUserById/{pkUserId}")
    public Result removeUserById(@PathVariable("pkUserId") String pkUserId) throws Exception {
        return success(userService.removeByPrimaryKey(pkUserId));
    }

    @ApiOperation("根据ID移除用户（物理删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUserById/{pkUserId}")
    public Result deleteUserById(@PathVariable("pkUserId") String pkUserId) throws Exception {
        return success(userService.deleteByPrimaryKey(pkUserId));
    }

    @ApiOperation("批量删除用户（逻辑删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "removeUserBatch")
    public Result removeUserBatch(@RequestParam String[] pkUserIds) throws Exception {
        return success(userService.removeUserBatch(pkUserIds));
    }

    @ApiOperation("批量删除用户（物理删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUserBatch")
    public Result deleteUserBatch(@RequestParam String[] pkUserIds) throws Exception {
        return success(userService.deleteUserBatch(pkUserIds));
    }

}
