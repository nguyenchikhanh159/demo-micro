package com.micro.redispubsub.configuration;

public interface MessagePublisher {
    void publish(String message);
}
