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
public class CentreCommercial implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nom;
    @Column
    private String adresse;
    @Column
    private String login;
    @Column
    private String password;

    @OneToMany(mappedBy = "centreCommercial", cascade={CascadeType.PERSIST, CascadeType.REMOVE},
            fetch=FetchType.EAGER)
    private Set<Boutique> boutiques;
}
