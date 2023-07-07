package com.example.spring.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component
public class SpringTest2 {

    public SpringTest2() {
        log.info("SpringTest2:我是无参构造器！");
    }

    @PostConstruct
    public void postConstruct(){
        log.info("SpringTest2:我是在构造器后做点什么！");
    }

    @PreDestroy
    public void preDestroy(){
        log.info("SpringTest2:我是在销毁前做点什么！");
    }


}
