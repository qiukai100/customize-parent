package com.customize.feign.fallback.hbase;

import com.alibaba.fastjson.JSONObject;
import com.customize.feign.modules.HBaseResult;
import com.customize.feign.service.hbase.PictureFeignService;
import com.customize.feign.utils.JsonResultUtil;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class PictureFeignFallback implements FallbackFactory<PictureFeignService> {

    @Override
    public PictureFeignService create(Throwable throwable) {
        return new PictureFeignService() {
            @Override
            public JSONObject uploadPicture(String tableName, String rowKey, String columnName, MultipartFile pictureFile) {
                return JsonResultUtil.beanToJson(HBaseResult.error(throwable.getMessage()));
            }

            @Override
            public String uploadPictures(String[] tableNames, String[] rowKeys, String[] columnNames, MultipartFile[] photoFiles) {
                return null;
            }

            @Override
            public JSONObject testConn(int connTime) {
                return JsonResultUtil.beanToJson(HBaseResult.error(throwable.getMessage()));
            }
        };
    }
}
