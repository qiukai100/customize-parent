package com.customize.mybatis.mapper.sys;

import com.customize.domain.dto.sys.PostDto;
import com.customize.domain.entity.sys.Post;
import com.customize.domain.vo.sys.PostVo;
import com.customize.mybatis.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据层接口
 * 岗位表 sys_post
 *
 * @author qiukai
 * @date 2020-04-25
 */
public interface PostMapper extends BaseMapper<Post> {

    /**
     * 条件查询岗位
     */
    List<PostDto> queryPostList(@Param("postVo") PostVo postVo);

    /**
     * 查询所有岗位
     */
    List<PostDto> selectPostList(@Param("isDelete") Integer isDelete);

    /**
     * 根据ID查询岗位
     */
    PostDto findById(@Param("pkPostId") String pkPostId, Integer isDelete);

    /**
     * 根据ID移除岗位（逻辑删除）
     */
    int removeByPrimaryKey(@Param("pkPostId") String pkPostId, @Param("isDelete") Integer isDelete);

    /**
     * 批量移除岗位（逻辑删除）
     */
    int removePostBatch(@Param("pkPostIds") String[] pkPostIds, @Param("isDelete") Integer isDelete);

    /**
     * 批量删除岗位（物理删除）
     */
    int deletePostBatch(@Param("pkPostIds") String[] pkPostIds);
}
