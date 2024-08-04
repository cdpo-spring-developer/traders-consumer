package com.springlessons.tradersconsumer.service.rabbit;


import com.springlessons.tradersconsumer.dto.Trader;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@EnableRabbit
@Service
public class RabbitConsumer {

    @RabbitListener(queues = "TRADER")
    public void receiveMessage(Trader trader) {
        System.out.println("Consumed trader: " + trader);
    }
}
