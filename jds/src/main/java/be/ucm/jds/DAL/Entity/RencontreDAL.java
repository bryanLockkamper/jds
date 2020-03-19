package be.ucm.jds.DAL.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Setter
@Getter
@Entity(name = "Rencontre")
public class RencontreDAL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rencontre;

    private String titre_rencontre;

    private LocalDate date_rencontre;
    private Integer tempDeJeu_rencontre;
    private Integer nbrParticipantLimite_rencontre;
    private String descr_rencontre;

    @OneToOne
    private PhotoDAL photo_rencontre;

    @OneToOne
    private AdresseDAL adresse_rencontre;

    @OneToOne
    private UtilisateurDAL utilisateur_rencontre;

    @ManyToMany
    private List<UtilisateurDAL> utilisateurList_rencontre;

    @ManyToMany
    private List<JeuDAL> jeuList_rencontre;
}
