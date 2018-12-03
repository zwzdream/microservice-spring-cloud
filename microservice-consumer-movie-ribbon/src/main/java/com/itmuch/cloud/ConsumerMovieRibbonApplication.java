package com.itmuch.cloud;

import com.itmuch.config.TestRibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 *@EnableEurekaClient注册服务
 *@RibbonClient指定ribbon使用的负载均衡策略
 *    name：指定提供者的serviceId(即spring.application.name)
 *    configuration指定自定义ribbon策略的类
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="microservice-provider-user",configuration = TestRibbonConfiguration.class)

public class ConsumerMovieRibbonApplication {

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
    SpringApplication.run(ConsumerMovieRibbonApplication.class, args);
  }
}
