package com.customize.web.controller.sys;

import com.customize.web.core.BaseController;
import com.customize.web.core.Result;
import com.customize.domain.vo.sys.PostVo;
import com.customize.domain.dto.sys.PostDto;
import com.customize.service.service.sys.IPostService;

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
@RequestMapping("sys/post")
@Api(value = "sys/post", description  = "岗位管理接口")
public class PostController extends BaseController {

    private final IPostService postService;

    @Autowired
    public PostController(IPostService postService) throws Exception {
        this.postService = postService;
    }

    @ApiOperation("分页条件查询岗位")
    @RequestMapping(method = RequestMethod.GET, value = "queryPostPage")
    public Result queryPostPage(PostVo postVo) throws Exception {
        return success(postService.queryPostPage(postVo));
    }

    @ApiOperation("条件查询岗位")
    @RequestMapping(method = RequestMethod.GET, value = "queryPostList")
    public Result queryPostList(PostVo postVo) throws Exception {
        return success(postService.queryPostList(postVo));
    }

    @ApiOperation("查询所有岗位")
    @RequestMapping(method = RequestMethod.GET, value = "selectPostList")
    public Result selectPostList() throws Exception {
        return success(postService.selectPostList());
    }

    @ApiOperation("根据ID查询岗位")
    @RequestMapping(method = RequestMethod.GET, value = "findPostById/{pkPostId}")
    public Result findById(@PathVariable("pkPostId") String pkPostId) {
        return success(postService.findById(pkPostId));
    }

    @ApiOperation("新增岗位")
    @RequestMapping(method = RequestMethod.POST, value = "insertPost")
    public Result insertPost(PostDto postDto) throws Exception {
        return success(postService.insertSelective(postDto));
    }

    @ApiOperation("修改岗位")
    @RequestMapping(method = RequestMethod.PUT, value = "updatePost")
    public Result updatePost(PostDto postDto) throws Exception {
        return success(postService.updateByPrimaryKeySelective(postDto));
    }

    @ApiOperation("根据ID移除岗位（逻辑删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "removePostById/{pkPostId}")
    public Result removePostById(@PathVariable("pkPostId") String pkPostId) throws Exception {
        return success(postService.removeByPrimaryKey(pkPostId));
    }

    @ApiOperation("根据ID移除岗位（物理删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "deletePostById/{pkPostId}")
    public Result deletePostById(@PathVariable("pkPostId") String pkPostId) throws Exception {
        return success(postService.deleteByPrimaryKey(pkPostId));
    }

    @ApiOperation("批量删除岗位（逻辑删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "removePostBatch")
    public Result removePostBatch(@RequestParam String[] pkPostIds) throws Exception {
        return success(postService.removePostBatch(pkPostIds));
    }

    @ApiOperation("批量删除岗位（物理删除）")
    @RequestMapping(method = RequestMethod.DELETE, value = "deletePostBatch")
    public Result deletePostBatch(@RequestParam String[] pkPostIds) throws Exception {
        return success(postService.deletePostBatch(pkPostIds));
    }

}
