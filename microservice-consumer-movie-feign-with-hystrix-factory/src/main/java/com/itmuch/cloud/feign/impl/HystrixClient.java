package com.itmuch.cloud.feign.impl;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.UserFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author WH1707008
 * @date 2018/11/1 16:45
 * Description:
 *  需要加生成实例的注解(如@Component(一般用这个),@Repository,@Service,@Controller)，不然启动时，会找不到这个类的实例
 *  实现一个Feign，作为hystrix回调类
 */
@Component
public class HystrixClient implements UserFeignClient {
    @Override
    public User findById(Long id) {
        User user=new User();
        user.setId(0L);
        user.setUsername("默认用户");
        return user;
    }
}
