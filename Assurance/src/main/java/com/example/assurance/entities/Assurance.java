package com.example.assurance.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Assurance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idAssurance;

    private String designation;

    private float montant;

    @ManyToOne
    private Contrat contrat;

    @ManyToOne
    private Benefeciaire benefeciaire;
}
