package com.itmuch.cloud.feign;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.impl.HystrixClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author WH1707008
 * @date 2018/11/5 15:47
 * Description:
 * 实现FallbackFactory<HystrixClient>，
 *
 */
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<HystrixClient> {
   private static final Logger LOGGER =LoggerFactory.getLogger(HystrixClientFallbackFactory.class);

    @Override
    public HystrixClient create(Throwable throwable) {
            HystrixClientFallbackFactory.LOGGER.info("fallback;reason was:{}",throwable.getMessage());
            return new HystrixClient(){
                @Override
                public User findById(Long id) {
                    User user=new User();
                    user.setId(-1L);
                    return user;
                }
            };

    }






}
