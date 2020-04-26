package com.customize.web.controller.sys;

import com.customize.web.core.BaseController;
import com.customize.web.core.Result;
import com.customize.domain.vo.sys.PostVo;
import com.customize.domain.dto.sys.PostDto;
import com.customize.service.service.sys.IPostService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.customize.web.core.Result.success;

/**
 * 视图层
 * 岗位表 sys_post
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Slf4j
@RestController
@RequestMapping("sys/post")
public class PostController extends BaseController {

    private final IPostService postService;

    @Autowired
    public PostController(IPostService postService) throws Exception {
        this.postService = postService;
    }

    /**
     * 分页条件查询岗位
     */
    @RequestMapping(method = RequestMethod.GET, value = "queryPostPage")
    public Result queryPostPage(PostVo postVo) throws Exception {
        return success(postService.queryPostPage(postVo));
    }

    /**
     * 条件查询岗位
     */
    @RequestMapping(method = RequestMethod.GET, value = "queryPostList")
    public Result queryPostList(PostVo postVo) throws Exception {
        return success(postService.queryPostList(postVo));
    }

    /**
     * 查询所有岗位
     */
    @RequestMapping(method = RequestMethod.GET, value = "selectPostList")
    public Result selectPostList() throws Exception {
        return success(postService.selectPostList());
    }

    /**
     * 根据ID查询岗位
     */
    @RequestMapping(method = RequestMethod.GET, value = "findPostById/{pkPostId}")
    public Result findById(@PathVariable("pkPostId") String pkPostId) {
        return success(postService.findById(pkPostId));
    }

    /**
     * 新增岗位
     */
    @RequestMapping(method = RequestMethod.POST, value = "insertPost")
    public Result insertPost(PostDto postDto) throws Exception {
        return success(postService.insertSelective(postDto));
    }

    /**
     * 修改岗位
     */
    @RequestMapping(method = RequestMethod.PUT, value = "updatePost")
    public Result updatePost(PostDto postDto) throws Exception {
        return success(postService.updateByPrimaryKeySelective(postDto));
    }

    /**
     * 根据ID移除岗位（逻辑删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "removePostById/{pkPostId}")
    public Result removePostById(@PathVariable("pkPostId") String pkPostId) throws Exception {
        return success(postService.removeByPrimaryKey(pkPostId));
    }

    /**
     * 根据ID移除岗位（物理删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "deletePostById/{pkPostId}")
    public Result deletePostById(@PathVariable("pkPostId") String pkPostId) throws Exception {
        return success(postService.deleteByPrimaryKey(pkPostId));
    }

    /**
     * 批量删除岗位（逻辑删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "removePostBatch")
    public Result removePostBatch(@RequestParam String[] pkPostIds) throws Exception {
        return success(postService.removePostBatch(pkPostIds));
    }

    /**
     * 批量删除岗位（物理删除）
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "deletePostBatch")
    public Result deletePostBatch(@RequestParam String[] pkPostIds) throws Exception {
        return success(postService.deletePostBatch(pkPostIds));
    }

}
