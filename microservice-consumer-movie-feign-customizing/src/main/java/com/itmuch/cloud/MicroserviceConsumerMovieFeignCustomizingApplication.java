package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**这里不写@EnableEurekaClient也可以
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MicroserviceConsumerMovieFeignCustomizingApplication {


  public static void main(String[] args) {
    SpringApplication.run(MicroserviceConsumerMovieFeignCustomizingApplication.class, args);
  }
}
