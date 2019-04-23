package com.customize.hbase.controller;

import com.customize.hbase.constants.ColumnFamilyType;
import com.customize.hbase.modules.Result;
import com.customize.hbase.service.HBaseService;
import com.customize.hbase.utils.PictureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            List<String> columns = Collections.singletonList(columnName);
            List<byte[]> values = Collections.singletonList(photoFile.getBytes());
            if (hBaseService.putData(tableName, rowKey, ColumnFamilyType.IMAGE.name(),
                    columns, values)) {
                return Result.success(PictureUtil.pathToUrl(tableName, rowKey, columnName));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
        return Result.error();
    }

    @RequestMapping(value = "uploadPictures", method = RequestMethod.POST)
    public List<String> uploadPictures(@RequestParam String[] tableNames, @RequestParam String[] rowKeys,
                                 @RequestParam String[] columnNames, @RequestParam MultipartFile[] photoFiles) {
        System.out.println(photoFiles.length);
        // TODO 暂无策略
        return new ArrayList<>();
    }

    @RequestMapping(value = "testConn", method = RequestMethod.POST)
    public Result testConn(int connTime) {
        try {
            Thread.sleep(connTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Result.error();
        }
        return Result.success();
    }
}
