package com.itheima.consumer.liseners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MQlisener {

    @RabbitListener(queues = "simple.queue")
    public void lisenerSimpleQueue(String msg){
        System.out.println("消费者收到了simple.queue的消息"+ msg);
    }
}