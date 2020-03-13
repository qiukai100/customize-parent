package com.customize.activity.controller;

import com.customize.activity.domain.vo.ActModelVO;
import com.customize.activity.service.ModelerService;
import com.customize.common.component.CommonResult;
import com.customize.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("modeler")
public class ModelerController {

    private final ModelerService actModelService;

    @Autowired
    public ModelerController(ModelerService actModelService) {
        this.actModelService = actModelService;
    }

    @GetMapping("showModel")
    public void showModel(String modelId,
                          HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActModelVO modelVO = ActModelVO.getDefaultModel();
        if (StringUtils.isBlank(modelId)) modelId = actModelService.createModel(modelVO).getId();
        response.sendRedirect(request.getContextPath() + "/modeler.html?modelId=" + modelId);
    }

    @PostMapping("createModel")
    public CommonResult createModel(@Valid @RequestBody ActModelVO actModelVO) throws Exception {
        log.debug("REST request to save Model : {}", actModelVO);
        Model model = actModelService.createModel(actModelVO);
        return CommonResult.success(model);
    }

    @GetMapping("getModel/{modelId}")
    public CommonResult getModel(@PathVariable String modelId) {
        log.debug("REST request to get Model : {}", modelId);
        return CommonResult.success(actModelService.getModelById(modelId));
    }

    @GetMapping("getAllModels")
    public CommonResult getAllModels(Pageable pageable) {
        final Page<Model> page = actModelService.getAllModels(pageable);
        return CommonResult.success(page.getContent());
    }

    @PutMapping("deployModel")
    public CommonResult deployModel(@RequestBody ActModelVO actModelVO) {
        String modelId = actModelVO.getId();
        log.debug("REST request to deploy Model : {}", modelId);
        try {
            List<ProcessDefinition> processDefinitions = actModelService.deployModel(modelId);
            if (!CollectionUtils.isEmpty(processDefinitions)) {
                return CommonResult.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    @DeleteMapping("deleteModel/{modelId}")
    public CommonResult deleteModel(@PathVariable String modelId) {
        log.debug("REST request to delete Model: {}", modelId);
        actModelService.deleteModel(modelId);
        return CommonResult.success();
    }

    @GetMapping("exportModel")
    public void exportModel(@RequestParam("modelId") String modelId, HttpServletResponse response) throws Exception {
        actModelService.exportModel(modelId, response);
    }

}
