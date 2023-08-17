package br.com.nathan.aws.producer.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {

    private String name;
    private String email;
    private String phone;
}
