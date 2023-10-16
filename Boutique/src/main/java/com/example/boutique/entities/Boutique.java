package com.example.boutique.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Boutique implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nom;
    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    @ManyToOne
    CentreCommercial centreCommercial;
    @ManyToMany
    Set<Client> clients;
}
