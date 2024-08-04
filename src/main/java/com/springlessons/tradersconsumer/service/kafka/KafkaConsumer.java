package com.springlessons.tradersconsumer.service.kafka;

import com.springlessons.tradersconsumer.dto.Trader;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {


    @KafkaListener(topics = {"TRADER"},
            topicPartitions = @TopicPartition(topic = "TRADER", partitions = "1"))
    public void consume(@Payload Trader trader,
                        @Header(KafkaHeaders.OFFSET) Integer offset,
                        @Header(KafkaHeaders.KEY) String key,
                        @Header(KafkaHeaders.PARTITION) int partition,
                        @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp,
                        Acknowledgment acknowledgment
    ) {
        System.out.println("Consumed trader: " + trader);
        System.out.println("OFFSET: " + offset);
        System.out.println("KEY: " + key);
        System.out.println("PARTITION: " + partition);
        System.out.println("TIMESTAMP: " + timestamp);
        acknowledgment.acknowledge();
    }
}
