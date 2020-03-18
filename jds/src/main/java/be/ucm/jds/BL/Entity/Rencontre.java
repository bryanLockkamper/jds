package be.ucm.jds.BL.Entity;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Rencontre {

    private Long id;
    private String titre;
    private LocalDate date;
    private int tempDeJeu;
    private Integer nbrParticipantsLimite;
    private Adresse adresse;
    private Photo photo;
    private String desc;
    private Utilisateur utilisateurCreateur;
    private List<Utilisateur> utilisateursParticipants;
    private List<Jeu> jeuList;
}
