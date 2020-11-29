package com.micro.redispubsub.configuration;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class RedismessageSubcribe implements MessageListener {
    public static List<String> messageList = new ArrayList<>();
    @Override
    public void onMessage(Message message, byte[] bytes){
        messageList.add(message.toString());
        System.out.println("Message received" + message.toString());
    }
}
