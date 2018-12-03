package com.itmuch.cloud.controller;

import com.itmuch.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class MovieController {
  @Autowired
  private RestTemplate restTemplate;

  @Value("${user.userServicePath}")
  private String userServicePath;

  @GetMapping("/movie/{id}")
  public User findById(@PathVariable Long id) {
    return this.restTemplate.getForObject(this.userServicePath + id, User.class);
  }

  @GetMapping("/list-all")
  public List<User> listAll(){



    //wrong,但是不知道为什么突然可以了
    List<User> list = this.restTemplate.getForObject("http://localhost:7900/list-all", List.class);


    //right
    // User[] users = this.restTemplate.getForObject("http://localhost:7900/list-all", User[].class);
    //List<User> list = Arrays.asList(users);

    return list;
  }

  @GetMapping("get-map")
  public Map getMap(){
    Map  map= this.restTemplate.getForObject("http://localhost:7900/get-map", Map.class);
    map.forEach((k,v)-> System.out.println(k+":"+v));
    return map;

  }
}
