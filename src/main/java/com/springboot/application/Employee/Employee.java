package com.springboot.application.Employee;

import java.time.LocalDate;
import java.util.List;

import com.springboot.application.Adresse.Adresse;
import com.springboot.application.Departement.Departement;
import com.springboot.application.Mission.Mission;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
    @OneToOne
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;
    @ManyToOne
    @JoinColumn(name="departement_id")
    private Departement departement;
     @ManyToMany
    @JoinTable(
        name = "employee_mission",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "mission_id")
    )
    private List<Mission> missions;
}
