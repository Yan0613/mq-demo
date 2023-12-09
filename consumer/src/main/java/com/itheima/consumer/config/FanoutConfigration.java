package com.itheima.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfigration {
    @Bean
    public FanoutExchange fanoutConfigration(){
        return new FanoutExchange("hmall.fanout");
//        ExchangeBuilder.fanoutExchange("hamll.fanout").build();不想return new的用下面这一种
    }

    @Bean
    public Queue fanoutExchangeQueue3(){
       return QueueBuilder.durable("fanout.queue3").build();
    }

    //绑定
    @Bean
    public Binding fanoutBingding3(Queue fanoutQueue3, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue3).to(fanoutExchange);
    }
}
