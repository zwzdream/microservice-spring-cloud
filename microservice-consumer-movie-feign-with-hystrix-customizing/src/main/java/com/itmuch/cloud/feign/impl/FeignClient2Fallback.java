package com.itmuch.cloud.feign.impl;

import com.itmuch.cloud.feign.UserFeignClient2;
import org.springframework.stereotype.Component;

/**
 * @author WH1707008
 * @date 2018/11/1 17:51
 * Description:
 */
@Component
public class FeignClient2Fallback implements UserFeignClient2 {
    @Override
    public String findServieInfoFromEurekaByServiceName(String serviceName) {
        return "UserFeignClient2";
    }
}
