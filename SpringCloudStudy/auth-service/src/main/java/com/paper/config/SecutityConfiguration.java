package com.paper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class SecutityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().anyRequest().authenticated().and().formLogin().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        auth
                .inMemoryAuthentication()
                .passwordEncoder(encoder)
                .withUser("paper")
                .password(encoder.encode("123456"))
                .roles("USER");
    }
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }
    @Bean
    public JwtAccessTokenConverter tokenConverter(){  //Token转换器，将其转换为JWT
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("lbwnb");   //这个是对称密钥，一会资源服务器那边也要指定为这个
        return converter;
    }

    @Bean
    public TokenStore tokenStore(JwtAccessTokenConverter converter){  //Token存储方式现在改为JWT存储
        return new JwtTokenStore(converter);  //传入刚刚定义好的转换器
    }
}
