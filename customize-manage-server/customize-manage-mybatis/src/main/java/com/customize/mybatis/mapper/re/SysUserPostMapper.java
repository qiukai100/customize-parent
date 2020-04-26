package com.customize.mybatis.mapper.re;

import com.customize.domain.dto.re.SysUserPostDto;
import com.customize.domain.entity.re.SysUserPost;
import com.customize.domain.vo.re.SysUserPostVo;
import com.customize.mybatis.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据层接口
 * 关联用户岗位表 re_sys_user_post
 *
 * @author qiukai
 * @date 2020-04-26
 */
public interface SysUserPostMapper extends BaseMapper<SysUserPost> {

    /**
     * 条件查询关联用户岗位
     */
    List<SysUserPostDto> querySysUserPostList(@Param("sysUserPostVo") SysUserPostVo sysUserPostVo);

    /**
     * 查询所有关联用户岗位
     */
    List<SysUserPostDto> selectSysUserPostList(@Param("isDelete") Integer isDelete);

    /**
     * 根据ID查询关联用户岗位
     */
    SysUserPostDto findById(@Param("pkReUserPostId") String pkReUserPostId, Integer isDelete);

    /**
     * 根据ID移除关联用户岗位（逻辑删除）
     */
    int removeByPrimaryKey(@Param("pkReUserPostId") String pkReUserPostId, @Param("isDelete") Integer isDelete);

    /**
     * 批量移除关联用户岗位（逻辑删除）
     */
    int removeSysUserPostBatch(@Param("pkReUserPostIds") String[] pkReUserPostIds, @Param("isDelete") Integer isDelete);

    /**
     * 批量删除关联用户岗位（物理删除）
     */
    int deleteSysUserPostBatch(@Param("pkReUserPostIds") String[] pkReUserPostIds);
}
