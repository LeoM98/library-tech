package com.org.utb.app.librarytech.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address implements Serializable {

    //Identificación
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Nombre
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name is mandatory")
    private String name;

    /*//Library
    @OneToOne(mappedBy = "address")
    private Library library;*/

}
