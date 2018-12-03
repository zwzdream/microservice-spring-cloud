package com.itmuch.cloud.controller;

import com.itmuch.cloud.healthckeck.MyHealthChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author WH1707008
 * @date 2018/11/1 14:26
 * Description:
 */
@RestController
public class UpController {
    @Autowired
   private MyHealthChecker myHealthChecker;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/up")
    public String up(@RequestParam("up") Boolean up){
        myHealthChecker.setUp(up);
        return up.toString();
    }

    @RequestMapping(value = "/get-map",method = RequestMethod.GET)
    public Map getMap(){
        Map map = restTemplate.getForObject("http://microservice-provider-user/get-map", Map.class);
        return  map;
    }
}
