package com.customize.web.controller.sys;

import com.customize.web.core.BaseController;
import com.customize.web.core.Result;
import com.customize.domain.vo.sys.UserVo;
import com.customize.domain.dto.sys.UserDto;
import com.customize.service.service.sys.IUserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.customize.web.core.Result.success;

/**
 * 视图层
 * 用户表 sys_user
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Slf4j
@RestController
@RequestMapping("sys/user")
public class UserController extends BaseController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) throws Exception {
        this.userService = userService;
    }

    /**
     * 分页条件查询用户
     */
    @RequestMapping(method = RequestMethod.GET, value = "queryUserPage")
    public Result queryUserPage(UserVo userVo) throws Exception {
        return success(userService.queryUserPage(userVo));
    }

    /**
     * 条件查询用户
     */
    @RequestMapping(method = RequestMethod.GET, value = "queryUserList")
    public Result queryUserList(UserVo userVo) throws Exception {
        return success(userService.queryUserList(userVo));
    }

    /**
     * 查询所有用户
     */
    @RequestMapping(method = RequestMethod.GET, value = "selectUserList")
    public Result selectUserList() throws Exception {
        return success(userService.selectUserList());
    }

    /**
     * 根据ID查询用户
     */
    @RequestMapping(method = RequestMethod.GET, value = "findUserById/{pkUserId}")
    public Result findById(@PathVariable("pkUserId") String pkUserId) {
        return success(userService.findById(pkUserId));
    }

    /**
     * 新增用户
     */
    @RequestMapping(method = RequestMethod.POST, value = "insertUser")
    public Result insertUser(UserDto userDto) throws Exception {
        return success(userService.insertSelective(userDto));
    }

    /**
     * 修改用户
     */
    @RequestMapping(method = RequestMethod.PUT, value = "updateUser")
    public Result updateUser(UserDto userDto) throws Exception {
        return success(userService.updateByPrimaryKeySelective(userDto));
    }

    /**
     * 根据ID移除用户（逻辑删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "removeUserById/{pkUserId}")
    public Result removeUserById(@PathVariable("pkUserId") String pkUserId) throws Exception {
        return success(userService.removeByPrimaryKey(pkUserId));
    }

    /**
     * 根据ID移除用户（物理删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUserById/{pkUserId}")
    public Result deleteUserById(@PathVariable("pkUserId") String pkUserId) throws Exception {
        return success(userService.deleteByPrimaryKey(pkUserId));
    }

    /**
     * 批量删除用户（逻辑删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "removeUserBatch")
    public Result removeUserBatch(@RequestParam String[] pkUserIds) throws Exception {
        return success(userService.removeUserBatch(pkUserIds));
    }

    /**
     * 批量删除用户（物理删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUserBatch")
    public Result deleteUserBatch(@RequestParam String[] pkUserIds) throws Exception {
        return success(userService.deleteUserBatch(pkUserIds));
    }

}
