package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author WH1707008
 * @date 2018/11/9 16:17
 * Description:
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableConfigServer
@EnableEurekaClient
public class ConfigServerWithEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerWithEurekaApplication.class,args);
    }
}
