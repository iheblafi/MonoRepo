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
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nom;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToMany(mappedBy = "clients", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<Boutique> boutiques;

}
