package com.customize.feign.fallback.hbase;

import com.alibaba.fastjson.JSONObject;
import com.customize.feign.service.hbase.PictureFeignService;
import com.customize.feign.utils.JsonResultUtil;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import static com.customize.common.component.CommonResult.error;

@Component
public class PictureFeignFallback implements FallbackFactory<PictureFeignService> {

    @Override
    public PictureFeignService create(Throwable throwable) {
        return new PictureFeignService() {
            @Override
            public JSONObject uploadPicture(String tableName, String rowKey, String columnName, MultipartFile pictureFile) {
                return JsonResultUtil.beanToJson(error(throwable.getMessage()));
            }

            @Override
            public JSONObject uploadPictureMini(String tableName, String rowKey, String columnName, String photoFile) {
                return JsonResultUtil.beanToJson(error(throwable.getMessage()));
            }

            @Override
            public JSONObject getPicture(String tableName, String rowKey, String columnFamily, String columnName) {
                return JsonResultUtil.beanToJson(error(throwable.getMessage()));
            }
        };
    }
}
