package com.customize.service.service.sys;

import com.customize.domain.dto.sys.UserDto;
import com.customize.domain.entity.sys.User;
import com.customize.domain.vo.sys.UserVo;
import com.customize.service.core.BaseService;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 业务层接口
 * 用户表 sys_user
 *
 * @author qiukai
 * @date 2020-04-26
 */
public interface IUserService extends BaseService<User, String> {

    /**
     * 分页条件查询用户
     */
    Page<UserDto> queryUserPage(UserVo userVo);

    /**
     * 条件查询用户
     */
    List<UserDto> queryUserList(UserVo userVo);

    /**
     * 查询所有用户
     */
    List<UserDto> selectUserList();

    /**
     * 根据ID查询用户
     */
	UserDto findById(String pkUserId);

    /**
     * 根据ID移除用户（逻辑删除）
     */
    int removeByPrimaryKey(String pkUserId);

    /**
     * 批量移除用户（逻辑删除）
     */
    int removeUserBatch(String[] pkUserIds);

    /**
     * 批量删除用户（物理删除）
     */
    int deleteUserBatch(String[] pkUserIds);
}
