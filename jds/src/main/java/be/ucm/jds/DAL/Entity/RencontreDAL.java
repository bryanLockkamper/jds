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
    private Long id;

    private String titre;

    private LocalDate date;
    private Integer tempDeJeu;
    private Integer nbrParticipantLimite;
    private String description;

    @OneToOne
    private PhotoDAL photo;

    @OneToOne
    private AdresseDAL adresse;

    @ManyToOne
    private UtilisateurDAL utilisateurCrea;

    @ManyToMany
    private List<UtilisateurDAL> utilisateurAffList;

    @ManyToMany
    private List<JeuDAL> jeuList;
}
