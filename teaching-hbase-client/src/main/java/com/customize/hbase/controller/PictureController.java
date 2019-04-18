package com.customize.hbase.controller;

import com.customize.hbase.constants.ColumnFamilyType;
import com.customize.hbase.service.HBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
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

    /**
     * 图片上传
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "uploadPicture", method = RequestMethod.POST)
    public String uploadPicture(String tableName, String rowKey, String columnName, MultipartFile pictureFile) {
        List<String> columns = Collections.singletonList(columnName);
        List<String> values = Collections.emptyList();
        hBaseService.putData(tableName, rowKey, ColumnFamilyType.IMAGE.name(),
                columns.toArray(new String[0]), values.toArray(new String[0]));
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "uploadPictureList", method = RequestMethod.POST)
    public String uploadPicture(String tableName, String rowKey, List<String> columnName, List<MultipartFile> pictureFile) {

        return null;
    }
}
