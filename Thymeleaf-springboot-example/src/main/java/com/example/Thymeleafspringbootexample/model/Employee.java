package com.example.Thymeleafspringbootexample.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="TBL_EMPLOYEES")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email", length=200)
    private String email;
    @Column(name="last_updt_time")
    private Date now=new Date();

}
