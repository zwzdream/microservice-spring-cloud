package com.itmuch.cloud;

import com.itmuch.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author WH1707008
 * @date 2018/10/25 10:34
 * Description:
 *   注解@FeignClient指定服务发现组件上服务的serviceId,，调用eureka上名为"microservice-provider-user"的服务
 *  接口里面定义的方法需要使用Spring MVC的@RequestMapping注解，标注method属性，否则启动出错
 *  method请求方式最好与服务提供者的一样
 */
@FeignClient("microservice-provider-user")
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

    /**
     *
     * @param user
     * @return User
     * post请求测试
     *   microservice-provider-user的"/user"路径接受method为POST
     *   这里method方式可以为get、post，但不能是put、delete
     *   这里可以是get请求方式的原因：只要参数是复杂对象，即使指定了了是GET方法，feign依然会以POST方式进行发送请求。
     */
      @RequestMapping(method = RequestMethod.POST, value = "/user")
      User postUser(@RequestBody User user);

    /**请求不会成功,因为只要参数是复杂对象，即使指定了了是GET方法，
     * feign依然会以POST方式进行发送请求，而microservice-provider-user的"/get-user"
     * 为GET方式，所以这里会报错：
     * Request method 'POST' not supported
     *若是想以GET方法发送请求，需要使用@RequestParam注解传递参数,见getUserWithRequestParam方法
     * @param user
     * @return
     */
       @RequestMapping(method = RequestMethod.GET, value = "/get-user")
       User getUser(User user);

    /**
     *
     * @param id
     * @param username
     * @param name
     * @param age
     * @param balance
     * @return User
     * 使用@RequestParam分解复杂对象
     */
      @RequestMapping(method = RequestMethod.GET, value = "/get-user")
      User getUserWithRequestParam(@RequestParam(value = "id") Long id,@RequestParam(value = "username") String username,
                                   @RequestParam(value = "name") String name);


    /**
     *
     * @param user
     * @return
     * 上面的方法也可以这样写
     */
    @RequestMapping(method = RequestMethod.GET, value = "/get-user")
      User getUserByMap(@RequestParam Map<String, Object> userMap);

}
