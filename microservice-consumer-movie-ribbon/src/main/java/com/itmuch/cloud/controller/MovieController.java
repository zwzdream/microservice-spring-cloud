package com.itmuch.cloud.controller;

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
  @Autowired
  private LoadBalancerClient loadBalancerClient;


  @GetMapping("/movie/{id}")
  public User findById(@PathVariable Long id) {
    return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
  }

  /**
   * 自定义ribbon策略类在单独、不重叠的包下，并且注解microservice-provider-user使用自定义策略（随机策略）
   * 而microservice-provider-user2没有说明，即使用默认策略(轮询策略)
   * LoadBalancerClient是负载均衡客户端使用choose方法根据serviceId得到ServiceInstance;
   * @return
   */
  @GetMapping("/test")
  public String test(){
    ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
    System.out.println("1:"+serviceInstance.getHost()+":"+serviceInstance.getPort()+":"+serviceInstance.getServiceId());
    ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("microservice-provider-user2");
    System.out.println("2:"+serviceInstance2.getHost()+":"+serviceInstance2.getPort()+":"+serviceInstance2.getServiceId());

    return "1";
  }

  @GetMapping("/list-all")
  public List<User> listAll(){
    //wrong,但是不知道为什么突然可以了
    List<User> list = this.restTemplate.getForObject("http://microservice-provider-user/list-all", List.class);
    return list;
  }

}
