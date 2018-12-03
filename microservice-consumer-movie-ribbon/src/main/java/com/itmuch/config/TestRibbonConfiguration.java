package com.itmuch.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author WH1707008
 * @date 2018/10/23 17:46
 * Description:
 *  自定义的ribbon策略需要注解@Configuration
 *  应该放在@ComponentScan或@SpringBootApplication扫描不到的单独包下(即不能和启动Application类在一个目录下)
 *  也可是使用自定义注解标注策略类，然后在启动类上，配置@ComponentScan不扫描这个自定义注解注解的类
 *  @ComponentScan(excludeFilters ={@ComponentScan.Filter(type =FilterType.ANNOTATION,value={ExcludeFromComponentScan.class} )} )
 *  （否则这个策略将由所有@RibbonClients共享）
 *
 */
@Configuration
public class TestRibbonConfiguration {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
