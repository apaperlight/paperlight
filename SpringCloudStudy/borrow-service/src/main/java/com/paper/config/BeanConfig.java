package com.paper.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {
    //这是使用RestTemplate方法必须要注册bean，下面使用feign就可以不用了
    @Bean
    @LoadBalanced
    RestTemplate template(){
        return new RestTemplate();
    }
}
