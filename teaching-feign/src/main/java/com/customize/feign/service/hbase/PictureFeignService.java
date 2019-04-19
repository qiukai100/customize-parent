package com.customize.feign.service.hbase;

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

@FeignClient(value = FeignClientConstant.HBASE_CLIENT, path = FeignClientConstant.HBASE_CLIENT_PATH + "/picture",
        configuration = FeignMultipartConfig.class, fallbackFactory = PictureFeignFallback.class)
public interface PictureFeignService {

    @RequestMapping(value = "/uploadPicture", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadPicture(@RequestParam("tableName") String tableName, @RequestParam("rowKey") String rowKey, @RequestParam("columnName") String columnName,
                         @RequestPart("pictureFile") MultipartFile pictureFile);

    @RequestMapping(value = "/uploadPictures", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadPictures(@RequestPart("pictureFiles") MultipartFile[] pictureFiles);

}
