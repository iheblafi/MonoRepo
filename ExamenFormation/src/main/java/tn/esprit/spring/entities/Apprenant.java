package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Apprenant  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idApprenant;
    private String nom;

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy = "listApprenants")
    private Set<Formation> listFormations;


    private String prenom;
    private Integer telephone;
    private String email;

}
