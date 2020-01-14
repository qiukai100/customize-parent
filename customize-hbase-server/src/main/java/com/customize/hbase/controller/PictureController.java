package com.customize.hbase.controller;

import com.customize.hbase.constants.ColumnFamilyType;
import com.customize.hbase.modules.Result;
import com.customize.hbase.service.HBaseService;
import com.customize.hbase.utils.PictureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

@RestController
@RequestMapping("picture")
public class PictureController {

    private final HBaseService hBaseService;

    @Autowired
    public PictureController(HBaseService hBaseService) {
        this.hBaseService = hBaseService;
    }

    @RequestMapping(value = "uploadPicture", method = RequestMethod.POST)
    public Result uploadPicture(@RequestParam String tableName, @RequestParam String rowKey,
                                @RequestParam String columnName, @RequestParam MultipartFile photoFile) {
        try {
            byte[] bytes = photoFile.getBytes();
            BASE64Encoder encoder = new BASE64Encoder();
            String value = encoder.encode(bytes);
            if (hBaseService.putData(tableName, rowKey, ColumnFamilyType.IMAGE.name(),
                    columnName, value)) {
                String url = PictureUtil.pathToUrl(tableName, rowKey, columnName);
                return Result.success(url);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
        return Result.error();
    }

    @RequestMapping(value = "uploadPictureMini", method = RequestMethod.POST)
    public Result uploadPictureMini(@RequestParam String tableName, @RequestParam String rowKey,
                                @RequestParam String columnName, @RequestParam String photoFile) {
        try {
            if (hBaseService.putData(tableName, rowKey, ColumnFamilyType.IMAGE.name(),
                    columnName, photoFile)) {
                String url = PictureUtil.pathToUrl(tableName, rowKey, columnName);
                return Result.success(url);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
        return Result.error();
    }

    @RequestMapping(value = "getPicture", method = RequestMethod.POST)
    public Result getPicture(@RequestParam String tableName, @RequestParam String rowKey,
                             @RequestParam String columnFamily, @RequestParam String columnName) {
        try {
            String picture = hBaseService.getColumnValue(tableName, rowKey, columnFamily, columnName);
            if (picture != null && picture.length() != 0) {
                return Result.success(picture);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
        return Result.error();
    }
}
