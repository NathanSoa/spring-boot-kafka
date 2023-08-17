package br.com.nathan.microservice.consumer.infra.messaging.listener;

import br.com.nathan.microservice.consumer.custom.PersonKafkaListener;
import br.com.nathan.microservice.consumer.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "string-topic", groupId = "group-1")
    public void listen(String message, ConsumerRecordMetadata metadata) {
        log.info("Topic {}, Partition: {}", metadata.topic(), metadata.partition());
        log.info("Message received: {}", message);
    }

    @PersonKafkaListener(groupId = "group-1")
    public void listen(Person person, ConsumerRecordMetadata metadata) {
        log.info("Topic {}, Partition: {}", metadata.topic(), metadata.partition());
        log.info("Message received: {}", person);
    }
}
