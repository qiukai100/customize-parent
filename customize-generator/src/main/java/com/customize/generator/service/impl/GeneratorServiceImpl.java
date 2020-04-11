package com.customize.generator.service.impl;

import com.customize.generator.config.GenConfig;
import com.customize.generator.constants.Constants;
import com.customize.generator.constants.DatabaseEnum;
import com.customize.generator.domain.gen.TableInfo;
import com.customize.generator.mapper.GenMapper;
import com.customize.generator.service.GeneratorService;
import com.customize.generator.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class GeneratorServiceImpl implements GeneratorService {
    private static final Logger log = LoggerFactory.getLogger(GeneratorServiceImpl.class);

    private final GenConfig config;
    private final GenMapper genMapper;

    @Autowired
    public GeneratorServiceImpl(GenMapper genMapper, GenConfig config) {
        this.genMapper = genMapper;
        this.config = config;
    }

    @Override
    public void generatorCode(String tableName, DatabaseEnum databaseEnum) {
        TableInfo table = genMapper.selectTableByName(tableName);
        if (table == null) {
            log.debug("generatorCode is fail. table is not found. table name is {}", tableName);
            return;
        }
        table.setColumns(genMapper.selectTableColumnsByName(tableName));
        if (table.getColumns() == null || table.getColumns().size() < 1) {
            log.debug("generatorCode is fail. Columns is null. table name is {}", tableName);
            return;
        }

        GeneratorUtils.transTable(table, databaseEnum, config);
        Map<String, Object> params = VelocityUtils.loadParams(table, config);
        config.getTemplateInfos().forEach(templateInfo -> {
            String fileName = GeneratorUtils.getFileName(table.getClassName(), templateInfo.getTypeEnum());
            params.put("fileName", fileName.substring(0, fileName.lastIndexOf(".")));
            String data = VelocityUtils.generateCode(templateInfo.getVmPath(), params, Constants.UTF8);
            String filePath = GeneratorUtils.getFilePath(templateInfo.getFileDirectory(), templateInfo.getTypeEnum(),
                    table.getModuleName(), templateInfo.getAutoCompletion());
            File file = new File(filePath.concat(fileName));
            try {
                if (FileUtils.writeFile(data, file, Constants.UTF8, config.getCover())) {
                    log.info("generator code is success. tableName is {}. vmType is {}. file path is {}",
                            tableName, templateInfo.getTypeEnum().name(), file.getPath());
                } else {
                    log.info("generator code is error. tableName is {}. vmType is {}. file path is {}",
                            tableName, templateInfo.getTypeEnum().name(), file.getPath());
                }
            } catch (IOException e) {
                log.error("generator code is error.", e);
            }
        });
    }
}
