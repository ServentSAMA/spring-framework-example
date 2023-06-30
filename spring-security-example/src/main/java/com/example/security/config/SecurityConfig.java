package com.example.security.config;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * security配置
 *
 * @author 申
 * @date 2023/4/13
 * @since 1.0
 */
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AccessDeniedHandler accessDeniedHandler;
    private final AuthenticationEntryPoint authenticationEntryPoint;

    @Override
    public void configure(WebSecurity web) {
        web.ignoring();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭默认验证
//        http.formLogin().disable()
//                .httpBasic().disable();
        http.authorizeRequests()
                // 排除不需要验证的
                .antMatchers("/getId").permitAll()
                // 排除不需要验证的请求任何请求都需要验证
                .anyRequest().authenticated();
        // 自定义异常处理
        http.exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(authenticationEntryPoint);


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // 用户验证,当前使用的是内存验证方式
                .userDetailsService(inMemoryUserDetailsManager())
                // 密码加密方式 DelegatingPasswordEncoder是spring5.0之后引入的，默认使用bcrypt加密方式
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
    }

    private InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserDetails userDetails = new User("admin", encoder.encode("admin"), Lists.newArrayList(() -> "admin"));
        userDetailsManager.createUser(userDetails);


        return userDetailsManager;
    }

}
