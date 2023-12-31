package com.employee.management.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "first_name", nullable = false)
    private String firstName;


    @Column(name = "last_name")
    private String lastName;


    @Column(name = "email")
    private String email;

}

