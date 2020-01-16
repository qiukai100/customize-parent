package com.customize.redis.controller;

import com.customize.common.component.CommonResult;
import com.customize.common.utils.StringUtils;
import com.customize.redis.dto.KeyValueDto;
import com.customize.redis.service.RedisService;
import com.customize.redis.vo.KeyValueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.customize.common.component.CommonResult.success;

@RestController
@RequestMapping
public class RedisController {

    private final RedisService<String, Object> redisService;

    @Autowired
    public RedisController(RedisService<String, Object> redisService) {
        this.redisService = redisService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "selectRedisList")
    public CommonResult selectRedisList(KeyValueVo keyValueVo) {
        if (StringUtils.isBlank(keyValueVo.getKey())) {
            keyValueVo.setKey("*");
        }
        return success(redisService.selectAll(keyValueVo.getDbNo(), keyValueVo.getKey()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "insertRedis")
    public CommonResult insertRedis(KeyValueDto keyValueDto) {
        redisService.set(keyValueDto.getDbNo(), keyValueDto.getKey().toString(), keyValueDto.getValue());
        return success();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "removeRedis")
    public CommonResult removeRedis(KeyValueDto keyValueDto) {
        redisService.remove(keyValueDto.getDbNo(), keyValueDto.getKey().toString());
        return success();
    }
}
