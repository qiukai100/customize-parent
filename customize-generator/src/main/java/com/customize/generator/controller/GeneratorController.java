package com.customize.generator.controller;

import com.customize.generator.constants.DatabaseEnum;
import com.customize.generator.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generator")
public class GeneratorController {

    private final GeneratorService generatorService;

    @Autowired
    public GeneratorController(GeneratorService generatorService) {
        this.generatorService = generatorService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/generateCode/{tableName}")
    public void generateCode(@PathVariable("tableName") String tableName) {
        generatorService.generatorCode(tableName, DatabaseEnum.MYSQL);
    }

}
