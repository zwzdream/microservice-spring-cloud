package com.itmuch.cloud;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

/**
 * @author WH1707008
 * @date 2018/11/7 10:28
 * Description:
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(ZuulApplication.class);
        //关闭banner
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

    //使用正则表达式指定路由规则
 /*   @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper(
                "(?<name>^.+)-(?<version>v.+$)",
                "${version}/${name}");
    }*/
}
