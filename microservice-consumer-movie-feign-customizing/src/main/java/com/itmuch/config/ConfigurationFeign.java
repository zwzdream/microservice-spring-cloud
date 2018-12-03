package com.itmuch.config;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WH1707008
 * @date 2018/10/26 14:35
 * Description:
 */
@Configuration
public class ConfigurationFeign {
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }

    /**
     * 默认None，即 no logging
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
