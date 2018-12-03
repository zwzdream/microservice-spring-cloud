package com.itmuch.cloud.feign;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.impl.HystrixClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author WH1707008
 * @date 2018/10/25 10:34
 * Description:
 *   注解@FeignClient指定服务发现组件上服务的serviceId,，调用eureka上名为"microservice-provider-user"的服务
 *   fallback与fallbackFactory冲突，最多设置一个属性
 *   fallbackFactory指定打印异常属性的类
 *  接口里面定义的方法需要使用Spring MVC的@RequestMapping注解，标注method属性，否则启动出错
 *  method请求方式最好与服务提供者的一样
 *
 */
@FeignClient(value = "microservice-provider-user",fallbackFactory = HystrixClientFallbackFactory.class)
public interface UserFeignClient {

    /**
     *
     * @param id
     * @return User
     * 下面注解可以使用@GetMapping("/simple/{id}")代替，以前不支持
     * 注意：@PathVariable得设置value，否则会报错
     *   另外Spring MVC value指定的路径必须可访问
     *   microservice-provider-user的"/simple/{id}"路径接受method为GET
     *   这里method必须是GET方式，不然访问会出错
     */
    @RequestMapping(method = RequestMethod.GET, value = "/simple/{id}")
    User findById(@PathVariable("id") Long id);



}
