package be.ucm.jds.DAL.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode
@ToString
@Setter
@Getter
@Entity
public class Rencontre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rencontre;

    private String titre_rencontre;

    private LocalDate date_rencontre;
    private Integer tempDeJeu_rencontre;
    private Integer nbrParticipantLimite_rencontre;
    private String descr_rencontre;

    @OneToOne
    private Adresse adresse_rencontre;

    @OneToOne
    private Utilisateur utilisateur_rencontre;

    @ManyToMany
    private List<Utilisateur> utilisateurList_rencontre;

    @ManyToMany
    private List<Jeu> jeuList_rencontre;
}
