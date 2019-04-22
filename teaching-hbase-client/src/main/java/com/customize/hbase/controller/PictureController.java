package com.customize.hbase.controller;

import com.customize.hbase.constants.ColumnFamilyType;
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

    @ResponseBody
    @RequestMapping(value = "uploadPicture", method = RequestMethod.POST)
    public String uploadPicture(@RequestParam String tableName, @RequestParam String rowKey,
                                @RequestParam String columnName, @RequestParam MultipartFile photoFile) {
        List<String> columns = Collections.singletonList(columnName);
        List<byte[]> values = null;
        try {
            values = Collections.singletonList(photoFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        hBaseService.creatTable(tableName, Collections.singletonList(ColumnFamilyType.IMAGE.name()));
        boolean isSucc = hBaseService.putData(tableName, rowKey, ColumnFamilyType.IMAGE.name(),
                columns, values);
        if (isSucc) {
            return PictureUtil.pathToUrl(tableName, rowKey, columnName);
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "uploadPictures", method = RequestMethod.POST)
    public List<String> uploadPictures(@RequestParam String[] tableNames, @RequestParam String[] rowKeys,
                                 @RequestParam String[] columnNames, @RequestParam MultipartFile[] photoFiles) {
        System.out.println(photoFiles.length);
        // TODO 暂无策略
        return new ArrayList<>();
    }
}
