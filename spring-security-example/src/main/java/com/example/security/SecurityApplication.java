package com.example.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author shen
 * @date 2023-04-13
 */
@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
        SecurityContext emptyContext = SecurityContextHolder.createEmptyContext();
        Authentication authentication = new TestingAuthenticationToken("admin","admin","ADMIN");
        emptyContext.setAuthentication(authentication);
        SecurityContextHolder.setContext(emptyContext);
    }

}
