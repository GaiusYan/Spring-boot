package com.springboot.application.Mission;

import java.util.List;
import com.springboot.application.Employee.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Mission {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int duration;
    @ManyToMany
    private List<Employee> employees;
}
