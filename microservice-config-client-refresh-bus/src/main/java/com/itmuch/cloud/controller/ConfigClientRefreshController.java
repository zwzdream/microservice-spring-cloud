package com.itmuch.cloud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WH1707008
 * @date 2018/11/13 11:03
 * Description:
 */
@RestController
@RefreshScope
public class ConfigClientRefreshController {
    @Value("${profile}")
    private String profile;

    @GetMapping(value="/profile")
    public String getProfile(){
        return this.profile;
    }

    @GetMapping("/hello")
    public String hello(){
        String hello="hello";
        return hello;
    }

    @GetMapping("/hello2")
    public String hello2() throws Exception{
        ObjectMapper objectMapper=new ObjectMapper();
        String hello2 = objectMapper.writeValueAsString("hello2");
        return hello2;
    }
}
