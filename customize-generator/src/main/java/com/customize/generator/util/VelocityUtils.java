package com.customize.generator.util;

import com.customize.generator.config.GenConfig;
import com.customize.generator.domain.gen.TableInfo;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class VelocityUtils {

    /**
     * 初始化Velocity工具
     */
    public static void initVelocity(String encoding) {
        Properties properties = new Properties();
        // 加载classpath目录下的vm文件
        properties.setProperty("file.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        // 定义字符集
        properties.setProperty(Velocity.ENCODING_DEFAULT, encoding);
        properties.setProperty(Velocity.OUTPUT_ENCODING, encoding);
        // 初始化Velocity引擎，指定配置Properties
        Velocity.init(properties);
    }

    /**
     * 生成代码
     *
     * @param vmPath   模板文件路径
     * @param params   参数集
     * @param encoding 字符集
     */
    public static String generateCode(String vmPath, Map<String, Object> params, String encoding) {
        StringWriter sw = new StringWriter();
        VelocityContext context = new VelocityContext(params);
        Template template = Velocity.getTemplate(vmPath, encoding);
        template.merge(context, sw);
        String data = sw.toString();
        IOUtils.closeQuietly(sw);
        return data;
    }

    /**
     * 初始化参数
     *
     * @param table  表信息
     * @param config 生成规则
     */
    public static Map<String, Object> loadParams(TableInfo table, GenConfig config) {
        Map<String, Object> params = new HashMap<>();
        params.put("tableName", table.getTableName());
        params.put("tableComment", GeneratorUtils.replaceKeyword(table.getTableComment()));
        params.put("primaryKey", table.getPrimaryKey());
        params.put("className", table.getClassName());
        params.put("classname", table.getClassname());
        params.put("moduleName", table.getModuleName());
        params.put("columns", table.getColumns());
        params.put("author", config.getAuthor());
        params.put("datetime", DateUtils.getDate());
        params.put("params", config.getParams());
        config.getTemplateInfos().forEach(templateInfo -> {
            String key = templateInfo.getTypeEnum().name().concat("_PACKAGE");
            String val = GeneratorUtils.getClassPackage(templateInfo.getFileDirectory(), templateInfo.getTypeEnum(),
                    table.getModuleName(), templateInfo.getAutoCompletion());
            if (val != null) {
                params.put(key, val);
            }
        });
        return params;
    }
}
