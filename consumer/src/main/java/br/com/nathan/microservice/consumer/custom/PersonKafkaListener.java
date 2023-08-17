package br.com.nathan.microservice.consumer.custom;

import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@KafkaListener
public @interface PersonKafkaListener {

    @AliasFor(annotation = KafkaListener.class, attribute = "group-Id")
    String groupId() default "";

    @AliasFor(annotation = KafkaListener.class, attribute = "topics")
    String topics() default "object-topic";

    @AliasFor(annotation = KafkaListener.class, attribute = "containerFactory")
    String containerFactory() default "personKafkaListenerContainerFactory";
}
