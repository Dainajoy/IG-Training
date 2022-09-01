package com.example.SpringBootJmsInMemoryActiveMq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "Inmemory.queue")
    public void listener(String message){
        System.out.println( "Successfully received mesaage:"+message);
    }
}
