package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int salary;

//    public Employee(String firstName, String lastName, String email, LocalDate hireDate, Gender gender, int salary) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.hireDate = hireDate;
//        this.gender = gender;
//        this.salary = salary;
//    }

}
