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
    private List<Jeu> jeuList;
    private int nbrParticipantsLimite;
    private Adresse adresse;
    private List<Photo> photoList;
    private String desc;
    private Utilisateur utilisateurCreateur;
    private List<Utilisateur> utilisateursParticipants;
}
