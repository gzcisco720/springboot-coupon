package com.spring.coupon.permission;

import com.spring.coupon.vo.CheckPermissionRequest;
import com.spring.coupon.vo.CommonResponse;
import com.spring.coupon.vo.CreatePathRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "eureka-client-coupon-permission")
public interface PermissionClient {
    @RequestMapping(value = "/coupon-permission/create/path", method = RequestMethod.POST)
    CommonResponse<List<Integer>> createPath(
            @RequestBody CreatePathRequest request
    );
    @RequestMapping(value = "/coupon-permission/check/permission", method = RequestMethod.POST)
    Boolean checkPermission(@RequestBody CheckPermissionRequest request);
}
