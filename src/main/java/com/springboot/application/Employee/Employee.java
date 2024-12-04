package com.springboot.application.Employee;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor 
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;
    private String identifier;
    private String firstName;
    private String lastName;
    @Column(nullable = false,unique = true)
    private String email;
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
