package com.org.utb.app.librarytech.entities;


import com.org.utb.app.librarytech.validators.annotations.TimeConstraint;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Builder
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
    @NotNull(message = "Time is mandatory")
    @TimeConstraint
    private int time;

    /* //Address ID
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;*/


}
