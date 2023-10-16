package com.example.assurance.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Benefeciaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idbenef;

    private int cin;

    private String  nom;

    private String prenom;
    private String profession;
    private float salaire;

    @OneToMany (mappedBy = "benefeciaire")
    Set<Assurance> assuranceSet;
}
