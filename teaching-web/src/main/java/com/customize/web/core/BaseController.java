package com.customize.web.core;

import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.core.img.ImgUtil;
import com.alibaba.fastjson.JSONObject;
import com.customize.feign.service.hbase.PictureFeignService;
import com.customize.redis.server.RedisServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

public abstract class BaseController {

    @Autowired
    protected RedisServer redisServer;

    @Autowired
    protected PictureFeignService pictureFeignService;

    @Value("${server.max-http-header-size}")
    private long maxHttpHeaderSize;

    /**
     * 超出请求头限制大小采用大图片上传，否则小图片上传
     *
     * @param tableName 表名
     * @param rowKey    行键
     * @param photoFile 文件
     * @return 结果集
     * @throws Exception IOException
     */
    protected JSONObject uploadPicture(String tableName, String rowKey, MultipartFile photoFile) throws Exception {
        String fileName = photoFile.getOriginalFilename();
        String fileType;
        if (fileName == null) {
            fileType = ImgUtil.IMAGE_TYPE_JPG;
        } else {
            fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        byte[] bytes = photoFile.getBytes();
        String file = Base64Encoder.encode(bytes);
        long headLength = (tableName.concat(rowKey).concat(fileType).concat(file)).getBytes().length;
        // 预留1M长度做比较
        if ((maxHttpHeaderSize - 1024) > headLength) {
            // 低于请求头限制长度，采用小图片上传方式
            return pictureFeignService.uploadPictureMini(tableName, rowKey, fileType, file);
        } else {
            // 超出请求头限制长度，采用大图片上传方式
            return pictureFeignService.uploadPicture(tableName, rowKey, fileType, photoFile);
        }
    }
}
