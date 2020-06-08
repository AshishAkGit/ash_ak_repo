package com.example.springbootpersonexamplejava11.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Person {
    private  UUID id;
    @NotBlank
    private  String name;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
