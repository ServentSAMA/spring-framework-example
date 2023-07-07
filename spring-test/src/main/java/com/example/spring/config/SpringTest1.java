package com.example.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class SpringTest1 implements InitializingBean, DisposableBean {

    public SpringTest1() {
        log.info("SpringTest1:我是无参构造器！");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("SpringTest1:我是在做初始化bean的操作！");
    }

    @Override
    public void destroy() throws Exception {
        log.info("SpringTest1:我是在做销毁bean的操作！");
    }
}
