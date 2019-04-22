package com.customize.feign.fallback.hbase;

import com.customize.feign.service.hbase.PictureFeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class PictureFeignFallback implements FallbackFactory<PictureFeignService> {

    @Override
    public PictureFeignService create(Throwable throwable) {
        return new PictureFeignService() {
            @Override
            public String uploadPicture(String tableName, String rowKey, String columnName, MultipartFile pictureFile) {
                return null;
            }

            @Override
            public String uploadPictures(String[] tableNames, String[] rowKeys, String[] columnNames, MultipartFile[] photoFiles) {
                return null;
            }
        };
    }
}
