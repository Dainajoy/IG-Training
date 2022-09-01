package com.example.SpringBootJmsInMemoryActiveMq.config;


import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

@EnableJms
@Configuration

public class Config {

    @Bean
    public Queue queue(){
        return new ActiveMQQueue("Inmemory.queue");
    }
}
