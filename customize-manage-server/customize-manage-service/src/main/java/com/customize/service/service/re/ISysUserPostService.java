package com.customize.service.service.re;

import com.customize.domain.dto.re.SysUserPostDto;
import com.customize.domain.entity.re.SysUserPost;
import com.customize.domain.vo.re.SysUserPostVo;
import com.customize.service.core.BaseService;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 业务层接口
 * 关联用户岗位表 re_sys_user_post
 *
 * @author qiukai
 * @date 2020-04-25
 */
public interface ISysUserPostService extends BaseService<SysUserPost, String> {

    /**
     * 分页条件查询关联用户岗位
     */
    Page<SysUserPostDto> querySysUserPostPage(SysUserPostVo sysUserPostVo);

    /**
     * 条件查询关联用户岗位
     */
    List<SysUserPostDto> querySysUserPostList(SysUserPostVo sysUserPostVo);

    /**
     * 查询所有关联用户岗位
     */
    List<SysUserPostDto> selectSysUserPostList();

    /**
     * 根据ID查询关联用户岗位
     */
	SysUserPostDto findById(String pkReUserPostId);

    /**
     * 根据ID移除关联用户岗位（逻辑删除）
     */
    int removeByPrimaryKey(String pkReUserPostId);

    /**
     * 批量移除关联用户岗位（逻辑删除）
     */
    int removeSysUserPostBatch(String[] pkReUserPostIds);

    /**
     * 批量删除关联用户岗位（物理删除）
     */
    int deleteSysUserPostBatch(String[] pkReUserPostIds);
}
