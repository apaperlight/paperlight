package com.paper.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.annotation.Resource;

@EnableAuthorizationServer
@Configuration
public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {
    @Resource
    private AuthenticationManager manager;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.
                inMemory()
                .withClient("web")
                .secret(encoder.encode("654321"))
                .autoApprove(true)
                .scopes("user","book","borrow")
                .redirectUris("http://localhost:8201/login","http://localhost:8101/login","http://localhost:8301/login")
                .authorizedGrantTypes("client_credentials","password","implicit","authorization_code","refresh_token");
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.
                passwordEncoder(encoder)
                .allowFormAuthenticationForClients()
                .checkTokenAccess("permitAll()");
    }
    @Resource
    UserDetailsService service;
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                .tokenServices(serverTokenServices())   //设定为刚刚配置好的AuthorizationServerTokenServices
                .userDetailsService(service)
                .authenticationManager(manager);
    }
    @Resource
    TokenStore store;

    @Resource
    JwtAccessTokenConverter converter;

    private AuthorizationServerTokenServices serverTokenServices(){  //这里对AuthorizationServerTokenServices进行一下配置
        DefaultTokenServices services = new DefaultTokenServices();
        services.setSupportRefreshToken(true);   //允许Token刷新
        services.setTokenStore(store);   //添加刚刚的TokenStore
        services.setTokenEnhancer(converter);   //添加Token增强，其实就是JwtAccessTokenConverter，增强是添加一些自定义的数据到JWT中
        return services;
    }


}
