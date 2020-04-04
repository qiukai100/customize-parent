package com.customize.generator.util;

import com.customize.generator.config.GenConfig;
import com.customize.generator.constants.DatabaseEnum;
import com.customize.generator.constants.MySqlDataTypeEnum;
import com.customize.generator.constants.TempTypeEnum;
import com.customize.generator.domain.gen.ColumnInfo;
import com.customize.generator.domain.gen.TableInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GeneratorUtils {
    private static final Logger log = LoggerFactory.getLogger(GeneratorUtils.class);

    // java文件包路径
    private final static String CLASS_PATH_PACK = "src/main/java/";

    /**
     * 整理表信息
     *
     * @param table        表信息
     * @param databaseEnum 数据库
     * @param config       生成规则
     */
    public static void transTable(TableInfo table, DatabaseEnum databaseEnum, GenConfig config) {
        String moduleName = null, tableShortName;
        if (config.getSplitPrefix()) {
            // 分割前缀，取第一位下划线之前的值为模块名
            String[] names = table.getTableName().split("_", 2);
            if (names.length < 2) {
                tableShortName = names[0];
            } else {
                if (config.getPrefixArray() != null && config.getPrefixArray().size() > 0) {
                    // 根据前缀的定义识别是否分割
                    if (config.getPrefixArray().contains(names[0])) {
                        moduleName = names[0];
                        tableShortName = names[1];
                    } else {
                        // 前缀中不包含此前缀，取全名
                        tableShortName = table.getTableName();
                    }
                } else {
                    // 不使用自定义的前缀
                    moduleName = names[0];
                    tableShortName = names[1];
                }
            }
        } else {
            // 不分割前缀，表名取全名，模块名为空
            tableShortName = table.getTableName();
        }
        table.setModuleName(moduleName);
        table.setClassName(StringUtils.convertToCamelCase(tableShortName));
        table.setClassname(StringUtils.uncapitalize(table.getClassName()));
        transColumns(table.getColumns(), databaseEnum);
        List<ColumnInfo> columnInfoList = new ArrayList<>(table.getColumns());
        table.setPrimaryKey(columnInfoList.get(0));
        table.getColumns().remove(0);
    }

    /**
     * 整理列信息
     */
    private static void transColumns(List<ColumnInfo> columnInfoList, DatabaseEnum databaseEnum) {
        columnInfoList.forEach(columnInfo -> {
            String attrName = StringUtils.convertToCamelCase(columnInfo.getColumnName());
            columnInfo.setAttrName(attrName);
            columnInfo.setAttrname(StringUtils.uncapitalize(attrName));

            switch (databaseEnum) {
                case MYSQL:
                    MySqlDataTypeEnum dataTypeEnum = MySqlDataTypeEnum.getEnum(columnInfo.getDataType());
                    columnInfo.setAttrType(dataTypeEnum.getJavaType());
                    columnInfo.setAttrPackage(dataTypeEnum.getPackageName());
                    break;
                case ORACLE:

                    break;
            }

        });
    }

    /**
     * 关键字替换
     */
    public static String replaceKeyword(String keyword) {
        return keyword.replaceAll("(?:表|信息|管理)", "");
    }

    /**
     * 获取类的包名
     *
     * @param path           文件路径
     * @param tempTypeEnum   模板类型
     * @param moduleName     模块名
     * @param autoCompletion 自动补全，true：在path后加上模块名和类名，false：自定义补全方式
     */
    public static String getClassPackage(String path, TempTypeEnum tempTypeEnum, String moduleName, boolean autoCompletion) {
        String[] paths = path.split(CLASS_PATH_PACK, 2);
        if (paths.length < 2) {
            log.debug("path is not class package. path is [{}]", path);
            return null;
        }
        String classPath = StringUtils.trimStringWith(paths[1], "/");
        classPath = classPath.replace("/", ".");
        if (moduleName == null || moduleName.trim().length() < 1) {
            moduleName = "";
        } else {
            moduleName = ".".concat(moduleName);
        }
        if (autoCompletion) {
            classPath = classPath.concat(moduleName);
        } else {
            // 自定义补全方式
            classPath = customizeCompletionPack(classPath, moduleName, tempTypeEnum);
        }
        return classPath;
    }

    /**
     * 获得类的文件路径（不包含文件名）
     *
     * @param path           文件路径
     * @param tempTypeEnum   模板类型
     * @param moduleName     模块
     * @param autoCompletion 自动补全，true：在path后加上模块名，false：自定义补全方式
     */
    public static String getFilePath(String path, TempTypeEnum tempTypeEnum, String moduleName, boolean autoCompletion) {
        if (moduleName == null || moduleName.trim().length() < 1) {
            moduleName = "";
        } else {
            moduleName = "/".concat(moduleName);
        }
        if (autoCompletion) {
            path = path.concat(moduleName).concat("/");
        } else {
            // 自定义补全方式
            path = customizeCompletionPath(path, moduleName, tempTypeEnum);
        }
        return path;
    }

    private static String customizeCompletionPath(String path, String moduleName, TempTypeEnum tempTypeEnum) {
        switch (tempTypeEnum) {
            case SERVICE_IMPL:
                return path.concat(moduleName).concat("/impl/");
            default:
                return path.concat(moduleName).concat("/");
        }
    }

    private static String customizeCompletionPack(String classPath, String moduleName, TempTypeEnum tempTypeEnum) {
        switch (tempTypeEnum) {
            case SERVICE_IMPL:
                return classPath.concat(moduleName).concat(".impl");
            default:
                return classPath.concat(moduleName);
        }
    }

    public static String getFileName(String className, TempTypeEnum tempTypeEnum) {
        switch (tempTypeEnum) {
            case WEB:
                return className.concat("Controller.java");
            case VO:
                return className.concat("Vo.java");
            case DTO:
                return className.concat("Dto.java");
            case ENTITY:
                return className.concat(".java");
            case MAPPER:
                return className.concat("Mapper.java");
            case SERVICE:
                return "I".concat(className).concat("Service.java");
            case SERVICE_IMPL:
                return className.concat("ServiceImpl.java");
            case MAPPER_XML:
                return className.concat("Mapper.xml");
            default:
                return className;
        }
    }
}