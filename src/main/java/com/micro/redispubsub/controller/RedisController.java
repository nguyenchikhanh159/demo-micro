package com.micro.redispubsub.controller;


import com.micro.redispubsub.configuration.RedismessagePublisher;
import com.micro.redispubsub.configuration.RedismessageSubcribe;
import com.micro.redispubsub.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/redis")
public class RedisController {
    private static Logger logger = LoggerFactory.getLogger(RestController.class);
    @Autowired
    private RedismessagePublisher messagePublisher;

    @PostMapping("/publish")
    public void publish(@RequestBody Message message){
        logger.info(">> publishing : {} ",message);
        messagePublisher.publish(message.toString());
    }
    public List<String> getMessage(){
        return RedismessageSubcribe.messageList;
    }
}
