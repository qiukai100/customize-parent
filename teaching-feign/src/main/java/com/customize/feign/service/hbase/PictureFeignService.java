package com.customize.feign.service.hbase;

import com.alibaba.fastjson.JSONObject;
import com.customize.component.config.FeignMultipartConfig;
import com.customize.feign.constants.FeignClientConstant;
import com.customize.feign.fallback.hbase.PictureFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * HBASE Feign接口
 * 1、调用时，必须使用RequestParam指定参数名
 * 2、MultipartFile类型必须使用RequestPart
 * 3、TODO MultipartFile参数名目前不能通过RequestPart指定，默认使用FieldName
 */
@FeignClient(value = FeignClientConstant.HBASE_CLIENT, path = FeignClientConstant.HBASE_CLIENT_PATH + "/picture",
        configuration = FeignMultipartConfig.class, fallbackFactory = PictureFeignFallback.class)
public interface PictureFeignService {

    @RequestMapping(value = "/uploadPicture", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    JSONObject uploadPicture(@RequestParam("tableName") String tableName, @RequestParam("rowKey") String rowKey, @RequestParam("columnName") String columnName,
                             @RequestPart MultipartFile photoFile);

    /**
     * 图片上传
     * @param tableName
     * @param rowKey
     * @param columnName
     * @param photoFile
     * @return
     */
    @RequestMapping(value = "/uploadPictureMini", method = RequestMethod.POST)
    JSONObject uploadPictureMini(@RequestParam("tableName") String tableName, @RequestParam("rowKey") String rowKey, @RequestParam("columnName") String columnName,
                             @RequestParam("photoFile") String photoFile);

    @RequestMapping(value = "getPicture", method = RequestMethod.POST)
    JSONObject getPicture(@RequestParam("tableName") String tableName, @RequestParam("rowKey") String rowKey,
                          @RequestParam("columnFamily") String columnFamily, @RequestParam("columnName") String columnName);
}
