package com.itmuch.cloud.controller;

import com.netflix.discovery.EurekaClient;
import com.netflix.ribbon.Ribbon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.entity.User;

@RestController
public class MovieController {
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private LoadBalancerClient loadBalancerClient;


  @GetMapping("/movie/{id}")
  public User findById(@PathVariable Long id) {
    ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
    System.out.println("==="+serviceInstance.getHost()+":"+serviceInstance.getPort()+":"+serviceInstance.getServiceId()+"===");
    return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
  }



}
