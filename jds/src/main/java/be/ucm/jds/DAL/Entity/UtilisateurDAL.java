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
@Entity(name = "Utilisateur")
public class UtilisateurDAL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @Column(nullable = false , unique = true)
    private String email_user;
    @Column(nullable = false)
    private String mdp_user;
    @Column(nullable = false)
    private String pseudo_user;
    @Column(nullable = false)
    private LocalDate dateNaiss_user;
    private String genre_user;
    private String nom_user;
    private String prenom_user;
    private String descr_user;
    private String numTel_user;

    @OneToOne
    private PhotoDAL photo_user;

    @ManyToMany(mappedBy = "utilisateurList_jeu")
    private List<JeuDAL> jeuList_utilisateur;

    @ManyToMany(mappedBy = "utilisateurList_adresse")
    private List<AdresseDAL> adresseList_utilisateur;

    @ManyToMany(mappedBy = "utilisateurList_rencontre")
    private List<RencontreDAL> rencontreList_utilisateur;

    @OneToOne
    private RencontreDAL rencontre_utilisateur;
}
