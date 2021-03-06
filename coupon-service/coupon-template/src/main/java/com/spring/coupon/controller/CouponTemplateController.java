package com.spring.coupon.controller;

import com.alibaba.fastjson.JSON;
import com.spring.coupon.vo.TemplateRequest;
import com.spring.coupon.entity.CouponTemplate;
import com.spring.coupon.exception.CouponException;
import com.spring.coupon.service.IBuildTemplateService;
import com.spring.coupon.service.ITemplateBaseService;
import com.spring.coupon.vo.CouponTemplateSDK;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class CouponTemplateController {
    private final IBuildTemplateService buildTemplateService;
    private final ITemplateBaseService templateBaseService;

    public CouponTemplateController(IBuildTemplateService buildTemplateService, ITemplateBaseService templateBaseService) {
        this.buildTemplateService = buildTemplateService;
        this.templateBaseService = templateBaseService;
    }

    @PostMapping("/template/build")
    public CouponTemplate buildTemplate(@RequestBody TemplateRequest request)
            throws CouponException {
        log.info("createTemplate: {}", JSON.toJSONString(request));
        return  buildTemplateService.buildTemplate(request);
    }

    @GetMapping("/template/info")
    public CouponTemplate buildTemplateInfo(@RequestParam("id") Integer id)
            throws CouponException {
        log.info("Get Template by ID: {}", id);
        return  templateBaseService.buildTemplateInfo(id);
    }

    @GetMapping("/template/sdk/all")
    public List<CouponTemplateSDK> findAllUsableTemplate() {
        log.info("findAllUsableTemplate");
        return templateBaseService.findAllUsableTemplate();
    }

    @GetMapping("/template/sdk/infos")
    public Map<Integer, CouponTemplateSDK> findIds2TemplateSDK(
            @RequestParam("ids") Collection<Integer> ids) {
        log.info("get template by id list");
        return templateBaseService.findIds2TemplateSDK(ids);
    }
}

