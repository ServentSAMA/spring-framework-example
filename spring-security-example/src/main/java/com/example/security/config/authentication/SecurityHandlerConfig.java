package com.example.security.config.authentication;

import com.example.security.config.base.HttpStatusEnum;
import com.example.security.config.base.RequestResult;
import com.example.security.config.util.ResponseUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;



/**
 * @author 申
 * @date 2023/4/13
 * @since 1.0
 */
@Configuration
public class SecurityHandlerConfig {

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> RequestResult.error(403, "权限不足");
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, authException) -> {
            if (authException instanceof InsufficientAuthenticationException) {
                ResponseUtil.response(response, HttpStatusEnum.STATUS_403);
            }
        };
    }

}
