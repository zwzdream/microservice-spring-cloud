package com.itmuch.cloud.controller;

import com.itmuch.cloud.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.entity.User;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MovieController {

  @Autowired
  private UserFeignClient userFeignClient;

  @GetMapping("/movie/{id}")
  public User findById(@PathVariable Long id) {
    return this.userFeignClient.findById(id);
  }

  @GetMapping("testPost")
    public User testPost(User user){
      return this.userFeignClient.postUser(user);
  }

    @GetMapping("testGet")
    public User testGet(User user){
        return this.userFeignClient.getUser(user);
    }

    @GetMapping("testGet2")
    public User testGet2(User user){
        return this.userFeignClient.getUserWithRequestParam(user.getId(),user.getUsername(),user.getName());
    }

    @GetMapping("testGet3")
    public User testGet3(User user){
        Map userMap=new HashMap<String,Object>();
        userMap.put("id", user.getId());
        userMap.put("username", user.getUsername());
        userMap.put("name", user.getName());
        return this.userFeignClient.getUserByMap(userMap);
    }


}
