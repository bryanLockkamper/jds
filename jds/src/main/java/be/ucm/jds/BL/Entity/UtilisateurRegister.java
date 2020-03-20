package be.ucm.jds.BL.Entity;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurRegister {

    private Long id;
    private String pseudo;
    private String mdp;
    private String email;
    private LocalDate dateNaissance;
    private String genre;
    private List<Jeu> jeuPreferes;
    private String nom;
    private String prenom;
    private String description;
    private String numero;
    private List<Adresse> adresseList;
    private Photo photo;
    private List<Rencontre> rencontreAffList;
    private List<Rencontre> rencontreCreaList;
}
