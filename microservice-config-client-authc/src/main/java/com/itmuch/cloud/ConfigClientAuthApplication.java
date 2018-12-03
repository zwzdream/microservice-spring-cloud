package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author WH1707008
 * @date 2018/11/9 16:17
 * Description:
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ConfigClientAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientAuthApplication.class,args);
    }
}
