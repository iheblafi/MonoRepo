package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Formateur implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
   private  Integer idFormateur;
    private String nom;
    private  String prenom;
    private  Integer tarifHoraire;
    private  String email;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "formateur")
    private Set<Formation> listFormations;
}
