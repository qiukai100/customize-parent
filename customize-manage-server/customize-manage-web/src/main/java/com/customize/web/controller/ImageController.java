package com.customize.web.controller;

import cn.hutool.core.codec.Base64Decoder;
import com.alibaba.fastjson.JSONObject;
import com.customize.common.component.CommonResult;
import com.customize.feign.utils.JsonResultUtil;
import com.customize.web.core.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("image")
@Api("图片管理")
public class ImageController extends BaseController {

    @ApiOperation("显示图片")
    @ApiImplicitParam(name = "tableName", value = "表名", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "showImage/{tableName}/{rowKey}/{columnFamily}/{columnName}", method = RequestMethod.GET)
    public void showImage(@PathVariable String tableName, @PathVariable String rowKey,
                          @PathVariable String columnFamily, @PathVariable String columnName,
                          HttpServletResponse response) {
        try {
            JSONObject jsonObject = pictureFeignService.getPicture(tableName, rowKey, columnFamily, columnName);
            CommonResult result = JsonResultUtil.jsonToBean(jsonObject, CommonResult.class);
            log.debug("pictureFeignService getPicture is end. response msg is [{}]", result.getMessage());
            String source = result.getData().toString();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64Decoder.decode(source));
            BufferedImage image = ImageIO.read(byteArrayInputStream);
            ImageIO.write(image, columnName, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            log.error("pictureFeignService getPicture is error", e);
        }
    }
}
