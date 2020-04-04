package com.customize.generator.service;

import com.customize.generator.constants.DatabaseEnum;

public interface GeneratorService {

    void generatorCode(String tableName, DatabaseEnum databaseEnum);
}
