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

    @RabbitListener(queues = "work.queue")
    public void lisenerWorkQueue(String msg){
        System.out.println("消费者1收到了simple.queue的消息"+ msg);
    }

    @RabbitListener(queues = "work.queue")
    public void lisenerWorkQueue2(String msg){
        System.out.println("消费者2收到了simple.queue的消息"+ msg);
    }

    @RabbitListener(queues = "direct.queue1")
    public void lisenerDirectQueue(String msg){
        System.out.println("消费者收到了direct.queue1的消息"+ msg);
    }

    @RabbitListener(queues = "direct.queue2")
    public void lisenerDirect2Queue(String msg){
        System.out.println("消费者收到了direct.queue2的消息"+ msg);
    }
}
