package com.example.data.jpa.config.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.nio.file.Watchable;

public class IdentifierGeneratorImpl implements IdentifierGenerator {


    private static final long WORKER_ID = 1;

    private static final long DATACENTER_ID = 1;

    private final Snowflake snowflake = IdUtil.createSnowflake(WORKER_ID,DATACENTER_ID);

    public synchronized long snowflakeId(){
        return snowflake.nextId();
    }

    public synchronized long snowflakeId(long workerId, long datacenterId){
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return String.valueOf(snowflakeId());
    }
}
