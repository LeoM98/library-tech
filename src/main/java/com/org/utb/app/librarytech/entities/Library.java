package com.org.utb.app.librarytech.entities;


import com.org.utb.app.librarytech.validators.annotations.TimeConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Library implements Serializable {

    //Identificación
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Nombre
    @NotBlank(message = "Name is mandatory")
    private String name;

    // Antiguo
    @NotBlank(message = "Time is mandatory")
    @TimeConstraint
    @Digits(message = "must be a number", integer = 0, fraction = 0)
    private int time;

    /* //Address ID
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;*/


}
