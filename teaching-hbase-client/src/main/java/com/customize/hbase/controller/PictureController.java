package com.customize.hbase.controller;

import com.customize.hbase.service.HBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public String uploadPicture(@RequestParam("tableName") String tableName, @RequestParam("rowKey") String rowKey,
                                @RequestParam("columnName") String columnName, @RequestPart("pictureFile") MultipartFile pictureFile) {
        List<String> columns = Collections.singletonList(columnName);
        List<String> values = Collections.emptyList();
        /*hBaseService.putData(tableName, rowKey, ColumnFamilyType.IMAGE.name(),
                columns.toArray(new String[0]), values.toArray(new String[0]));*/
        return pictureFile.getName();
    }

    @ResponseBody
    @RequestMapping(value = "uploadPictures", method = RequestMethod.POST)
    public String uploadPictures(@RequestPart("pictureFiles") MultipartFile[] pictureFiles) {
        return String.valueOf(pictureFiles.length);
    }
}
