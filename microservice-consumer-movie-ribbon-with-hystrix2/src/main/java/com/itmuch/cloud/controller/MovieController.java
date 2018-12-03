package com.itmuch.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.entity.User;

import java.util.List;

@RestController
public class MovieController {
  @Autowired
  private RestTemplate restTemplate;


  /**
   *官网建议：不出错，不要配置commandProperties，
   * commandProperties = {@HystrixProperty(name="execution.isolation.strategy",value="SEMAPHORE")}
   * 配置commandProperties的作用是Propagating(传播) the Security Context
   * @param id
   * @return
   */
  @GetMapping("/movie/{id}")
  @HystrixCommand(fallbackMethod = "findByIdFallback")
  public User findById(@PathVariable Long id) {
    return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
  }

  /**
   * hystrix的一个fallbackMethod
   * 参数和返回值要和原方法一致
   * 方法名随便定义
   * @param id
   * @return
   */
  public User findByIdFallback(Long id){
    User user=new User();
    user.setId(0L);
    return user;
  }


}
