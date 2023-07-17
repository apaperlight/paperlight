package com.paper.config;

import org.springframework.cloud.client.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import javax.annotation.Resource;
import java.util.Collections;

@Configuration
public class WebConfiguration {
    @Resource
    OAuth2ClientContext context;
    @Bean
    @LoadBalanced
    public OAuth2RestTemplate restTemplate(){
        return new OAuth2RestTemplate(new ClientCredentialsResourceDetails(),context);
    }
}
