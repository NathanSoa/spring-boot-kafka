package br.com.nathan.microservice.consumer.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Person implements Serializable {

    private String name;
    private String email;
    private String phone;
}
