package com.cydeo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {

    private String firstName;
    private String lastName;
    private int age;
    private String state;
}
