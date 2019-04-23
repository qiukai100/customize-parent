package com.customize.web.controller;

import cn.hutool.core.codec.Base64Decoder;
import com.alibaba.fastjson.JSONObject;
import com.customize.feign.modules.HBaseResult;
import com.customize.feign.service.hbase.PictureFeignService;
import com.customize.feign.utils.JsonResultUtil;
import com.customize.web.core.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ImageController extends BaseController {

    private final PictureFeignService pictureFeignService;

    @Autowired
    public ImageController(PictureFeignService pictureFeignService) {
        this.pictureFeignService = pictureFeignService;
    }

    @RequestMapping(value = "showImage/{tableName}/{rowKey}/{columnFamily}/{columnName}", method = RequestMethod.GET)
    public void showImage(@PathVariable String tableName, @PathVariable String rowKey,
                          @PathVariable String columnFamily, @PathVariable String columnName,
                          HttpServletResponse response) {
        try {
            JSONObject jsonObject = pictureFeignService.getPicture(tableName, rowKey, columnFamily, columnName);
            HBaseResult hBaseResult = JsonResultUtil.jsonToBean(jsonObject, HBaseResult.class);
            log.debug("pictureFeignService getPicture is end. response msg is [{}]", hBaseResult.getMessage());
            String source = hBaseResult.getData().toString();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64Decoder.decode(source));
            BufferedImage image = ImageIO.read(byteArrayInputStream);
            ImageIO.write(image, columnName, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            log.error("pictureFeignService getPicture is error", e);
        }
    }
}
