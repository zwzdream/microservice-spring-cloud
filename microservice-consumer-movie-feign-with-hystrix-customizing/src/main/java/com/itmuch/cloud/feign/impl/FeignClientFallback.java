package com.itmuch.cloud.feign.impl;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.UserFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author WH1707008
 * @date 2018/11/1 17:54
 * Description:
 */
@Component
public class FeignClientFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        User user =new User();
        user.setUsername("按时");
        return user;
    }
}
