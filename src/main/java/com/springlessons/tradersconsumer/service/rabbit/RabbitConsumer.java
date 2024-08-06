package com.springlessons.tradersconsumer.service.rabbit;


import com.springlessons.tradersconsumer.dto.Trader;
import com.springlessons.tradersconsumer.service.database.TraderService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@EnableRabbit
@Service
public class RabbitConsumer {
    private final TraderService traderService;

    public RabbitConsumer(TraderService traderService) {
        this.traderService = traderService;
    }


    @RabbitListener(queues = "TRADER")
    public void receiveMessage(Trader trader) {
        System.out.println("Consumed trader: " + trader);
        traderService.saveTrader(trader);
    }
}
