package com.cydeo.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String email;
    private String name;
    private String surName;
    private String userName;

    @OneToMany(mappedBy = "customer")
    private List<Payment> paymentList;

}
