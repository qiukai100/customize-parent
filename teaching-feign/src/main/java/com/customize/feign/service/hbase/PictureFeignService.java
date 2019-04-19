package com.customize.feign.service.hbase;

import com.customize.feign.constants.FeignClientConstant;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = FeignClientConstant.HBASE_CLIENT, path = FeignClientConstant.HBASE_CLIENT_PATH + "/picture")
public interface PictureFeignService {

    @RequestMapping(value = "/testFeign", method = RequestMethod.GET)
    String testFeign(@RequestParam("msg") String msg);
}
