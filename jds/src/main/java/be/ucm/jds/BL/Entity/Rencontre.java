package be.ucm.jds.BL.Entity;

import be.ucm.jds.DAL.Entity.UtilisateurDAL;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Rencontre {

    private Long id;
    private String titre;
    private LocalDateTime date;
    private int tempsDeJeu;
    private Integer nbrParticipantLimite;
    private Adresse adresse;
    private String description;
    private Photo photo;
    private List<Jeu> jeuList;
    private Groupe groupeCrea;
    List<Utilisateur> utilisateurAffList;
}
