package br.com.nathan.aws.producer.controller;

import br.com.nathan.aws.producer.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@RestController
public class Controller {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Serializable> jsonKafkaTemplate;

    @GetMapping("/string")
    @ResponseStatus(HttpStatus.OK)
    public String sendMessage() {
        kafkaTemplate.send("string-topic", "Hello World!");
        return "message sent at " + LocalDateTime.now();
    }

    @GetMapping("/person")
    @ResponseStatus(HttpStatus.OK)
    public String sendPerson() {
        var person = new Person();
        person.setEmail("any@mail.com");
        person.setName("Any Name");
        person.setPhone("999999999");
        jsonKafkaTemplate.send("object-topic", person);
        return "message sent at " + LocalDateTime.now();
    }
}
