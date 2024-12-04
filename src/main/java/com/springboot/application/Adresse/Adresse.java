package com.springboot.application.Adresse;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
public class Adresse {
    @Id
    @GeneratedValue
    private Integer Id;
    private String streetName;
    private String HouseNumber;
    private String zipCode;
}
