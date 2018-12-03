package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *@EnableEurekaClient注册服务
 */
@SpringBootApplication
@EnableEurekaClient

public class ConsumerMoviePropertiesCustomizingRibbonApplication {

  /**
   * 实例化RestTemplate，通过@LoadBalanced注解开启均衡负载能力.
   * 负载均衡默认策略是轮询
   * @return restTemplate
   */
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    SpringApplication.run(ConsumerMoviePropertiesCustomizingRibbonApplication.class, args);
  }
}
