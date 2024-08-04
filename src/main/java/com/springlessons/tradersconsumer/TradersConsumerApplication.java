package com.springlessons.tradersconsumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;


@SpringBootApplication
public class TradersConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradersConsumerApplication.class, args);
    }

}
