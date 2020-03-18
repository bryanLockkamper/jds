package be.ucm.jds.BL.Entity;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {

    private Long id;
    private String pseudo;
    private LocalDate date;
    private String genre;
    private List<Jeu> jeuPreferes;
    private String nom;
    private String prenom;
    private String desc;
    private String telephone;
    private List<Adresse> adresseList;
    private Photo photo;
    private List<Rencontre> rencontreList;
}
