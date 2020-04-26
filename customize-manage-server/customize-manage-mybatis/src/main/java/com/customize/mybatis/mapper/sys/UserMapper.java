package com.customize.mybatis.mapper.sys;

import com.customize.domain.dto.sys.UserDto;
import com.customize.domain.entity.sys.User;
import com.customize.domain.vo.sys.UserVo;
import com.customize.mybatis.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据层接口
 * 用户表 sys_user
 *
 * @author qiukai
 * @date 2020-04-25
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 条件查询用户
     */
    List<UserDto> queryUserList(@Param("userVo") UserVo userVo);

    /**
     * 查询所有用户
     */
    List<UserDto> selectUserList(@Param("isDelete") Integer isDelete);

    /**
     * 根据ID查询用户
     */
    UserDto findById(@Param("pkUserId") String pkUserId, Integer isDelete);

    /**
     * 根据ID移除用户（逻辑删除）
     */
    int removeByPrimaryKey(@Param("pkUserId") String pkUserId, @Param("isDelete") Integer isDelete);

    /**
     * 批量移除用户（逻辑删除）
     */
    int removeUserBatch(@Param("pkUserIds") String[] pkUserIds, @Param("isDelete") Integer isDelete);

    /**
     * 批量删除用户（物理删除）
     */
    int deleteUserBatch(@Param("pkUserIds") String[] pkUserIds);
}
