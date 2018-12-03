package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author WH1707008
 * @date 2018/11/9 16:17
 * Description:
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableConfigServer
public class ConfigServerAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerAuthApplication.class,args);
    }
}
