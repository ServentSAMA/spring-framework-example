package com.example.data.redis.config;

import com.example.data.redis.config.handle.impl.MessageDelegateImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setStringSerializer(new StringRedisSerializer());
        redisTemplate.setDefaultSerializer(new StringRedisSerializer());

        return redisTemplate;
    }

    @Bean
    public MessageDelegateImpl messageDelegate(){
        return new MessageDelegateImpl();
    }

    @Bean
    RedisMessageListenerContainer redisMessageListenerContainer(MessageListenerAdapter messageListenerAdapter,
                                                                RedisConnectionFactory connectionFactory){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(messageListenerAdapter, ChannelTopic.of("screen"));

        return container;
    }

    @Bean
    MessageListenerAdapter messageListenerAdapter(MessageDelegateImpl messageDelegate){
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(messageDelegate, "handleMessage");
        messageListenerAdapter.afterPropertiesSet();
        return messageListenerAdapter;
    }


}
