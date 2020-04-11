package com.customize.generator.util;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {
    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

    private static final String FILE_SEPARATOR = "/";

    /**
     * 创建目录
     *
     * @param path 路径
     */
    public static boolean mkdirs(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }

    /**
     * 创建文件
     *
     * @param path  文件目录
     * @param cover 是否覆盖 - true：覆盖原文件
     */
    public static boolean createFile(String path, boolean cover) throws IOException {
        File file = new File(path);
        String dirPath = path.substring(0, path.lastIndexOf(getFileSeparator(path)));
        if (!mkdirs(dirPath)) {
            log.error("create file error. directory is not exists and create error. dirPath is [{}]. path is [{}]", dirPath, path);
            return false;
        }
        if (file.exists()) {
            if (cover) {
                if (!file.delete()) {
                    log.error("create file error. file is exists and delete file error. path is [{}]", path);
                    return false;
                }
            } else {
                log.error("create file error. file is exists. path is [{}]", path);
                return false;
            }
        }
        return file.createNewFile();
    }

    /**
     * 写文件
     *
     * @param data     文件内容
     * @param file     文件
     * @param encoding 字符集
     * @param cover    是否覆盖
     */
    public static boolean writeFile(String data, File file, String encoding, boolean cover) throws IOException {
        if (!createFile(file.getPath(), cover)) {
            log.error("write file error. create error. path is [{}]", file.getPath());
            return false;
        }
        FileOutputStream fos = new FileOutputStream(file);
        IOUtils.write(data, fos, encoding);
        fos.close();
        return true;
    }

    private static String getFileSeparator(String path) {
        if (path.contains(File.separator)) return File.separator;
        else return FILE_SEPARATOR;
    }
}
