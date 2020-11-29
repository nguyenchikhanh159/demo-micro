package com.micro.redispubsub.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

@Component
public class RedismessagePublisher implements MessagePublisher {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private ChannelTopic topic;

    public RedismessagePublisher(RedisTemplate<String, Object> redisTemplate, ChannelTopic topic) {
        this.redisTemplate = redisTemplate;
        this.topic = topic;
    }

    public RedismessagePublisher() {
    }

    @Override
    public void publish(String message) {
        redisTemplate.convertAndSend(topic.getTopic(),message);
    }
}
