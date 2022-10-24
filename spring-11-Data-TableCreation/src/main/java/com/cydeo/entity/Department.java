package com.cydeo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@AllArgsConstructor
public class Department extends BaseEntity{

    private String department;
    private String division;

//    public Department(String department, String division) {
//        this.department = department;
//        this.division = division;
//    }
}
