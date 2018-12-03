package com.itmuch.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author WH1707008
 * @date 2018/10/25 10:34
 * Description:
  *当有url属性时，name只是一个名称，可以任意取，没有url时，name为应用的名称，然后在Eureka解析成url
 */
@FeignClient(name="xxxx",url="http://localhost:8761/")
public interface UserFeignClient2 {

    @RequestMapping(method=RequestMethod.GET,value="/eureka/apps/{serviceName}")
  String findServieInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);



}
