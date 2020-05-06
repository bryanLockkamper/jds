package be.ucm.jds.DAL.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private LocalDateTime date;
    private Integer tempsDeJeu;
    private Integer nbrParticipantLimite;
    private String description;

    @OneToOne(cascade = {CascadeType.ALL})
    private PhotoDAL photo;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private AdresseDAL adresse;

    @ManyToOne
    private GroupeDAL groupeCrea;

    @ManyToMany
    private List<UtilisateurDAL> utilisateurAffList;

    @ManyToMany
    private List<JeuDAL> jeuList;
}
