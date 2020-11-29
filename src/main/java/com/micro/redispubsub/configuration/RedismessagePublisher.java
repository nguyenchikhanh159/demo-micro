package com.micro.redispubsub.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

@Component
public class RedismessagePublisher implements MessagePublisher {

    @Autowired
    private RedisTemplate<String,Object> resdisTemplate;
    @Autowired
    private ChannelTopic topic;

    public RedismessagePublisher(RedisTemplate<String,Object> redisTemplate,ChannelTopic topic){
        this.resdisTemplate=redisTemplate;
        this.topic=topic;
    }
    public RedismessagePublisher() {
    }
    @Override
    public void publish(String message){

    }
}
