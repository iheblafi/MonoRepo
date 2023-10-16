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
public class Formation implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idFormation;
    private String title;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Integer nbHeure;
    private Integer nbrMaxParticipant;
    private Integer frais;
    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(fetch=FetchType.EAGER)
    private Set<Apprenant> listApprenants;

    @JsonIgnore
    @ManyToOne()
    private Formateur formateur;
}
