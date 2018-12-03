package com.itmuch.cloud;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

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
}
