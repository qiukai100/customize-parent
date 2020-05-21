package com.customize.service.service.sys.impl;

import com.customize.common.constants.ConstantEnum;
import com.customize.common.constants.OptionEnum;
import com.customize.domain.dto.sys.UserDto;
import com.customize.domain.entity.sys.User;
import com.customize.domain.vo.sys.UserVo;
import com.customize.mybatis.mapper.sys.UserMapper;
import com.customize.service.core.BaseServiceImpl;
import com.customize.service.service.sys.IUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层实现
 * 用户表 sys_user
 *
 * @author qiukai
 * @date 2020-04-26
 */
@Slf4j
@Service
public class UserServiceImpl extends BaseServiceImpl<User, String> implements IUserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        super(userMapper);
        this.userMapper = userMapper;
    }

    @Override
    public Page<UserDto> queryUserPage(UserVo userVo) {
        return PageHelper.startPage(userVo.getPageNum(), userVo.getPageSize()).doSelectPage(() -> userMapper.queryUserList(userVo));
    }

    @Override
    public List<UserDto> queryUserList(UserVo userVo) {
        return userMapper.queryUserList(userVo);
    }

    @Override
    public List<UserDto> selectUserList() {
        return userMapper.selectUserList(OptionEnum.YES.getVal());
    }

    @Override
    public UserDto findById(String pkUserId) {
        return userMapper.findById(pkUserId, OptionEnum.YES.getVal());
    }

    @Override
    public UserDto findByCode(String userCode) {
        return userMapper.findByCode(userCode, OptionEnum.NO.getVal());
    }

    @Override
    public int removeByPrimaryKey(String pkUserId) {
        return userMapper.removeByPrimaryKey(pkUserId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeUserBatch(String[] pkUserIds) {
        return userMapper.removeUserBatch(pkUserIds, OptionEnum.YES.getVal());
    }

    @Override
    public int deleteUserBatch(String[] pkUserIds) {
        return userMapper.deleteUserBatch(pkUserIds);
    }
}
