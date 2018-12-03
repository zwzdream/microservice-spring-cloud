package com.itmuch.cloud.feign;

import com.itmuch.cloud.entity.User;
import com.itmuch.config.ConfigurationFeign;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author WH1707008
 * @date 2018/10/25 10:34
 * Description:
 *   注解@FeignClient指定服务发现组件上服务的serviceId,，调用eureka上名为"microservice-provider-user"的服务
 *  接口里面定义的方法需要使用Spring MVC的@RequestMapping注解，标注method属性，否则启动出错
 *  method请求方式最好与服务提供者的一样
 */
@FeignClient(name="microservice-provider-user",configuration = ConfigurationFeign.class)
public interface UserFeignClient {

    @RequestLine("GET /simple/{id}")
    User findById(@Param("id") Long id);



}
