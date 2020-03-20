package be.ucm.jds.DAL.Entity;

import be.ucm.jds.BL.Entity.Adresse;
import be.ucm.jds.BL.Entity.Jeu;
import be.ucm.jds.BL.Entity.Photo;
import be.ucm.jds.BL.Entity.Rencontre;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Setter
@Getter
@Entity(name = "Utilisateur")
public class UtilisateurDAL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , unique = true)
    private String email;
    @Column(nullable = false)
    private String mdp;
    @Column(nullable = false)
    private String pseudo;
    @Column(nullable = false)
    private LocalDate dateNaissance;
    private String genre;
    private String nom;
    private String prenom;
    private String description;
    private String numero;

    @OneToOne(cascade = CascadeType.ALL)
    private PhotoDAL photo;

    @ManyToMany(mappedBy = "utilisateurList", cascade = CascadeType.ALL)
    private List<JeuDAL> jeuPreferes;

    @ManyToMany(mappedBy = "utilisateurList", cascade = CascadeType.ALL)
    private List<AdresseDAL> adresseList;

    @ManyToMany(mappedBy = "utilisateurAffList")
    private List<RencontreDAL> rencontreAffList;

    @OneToMany
    private List<RencontreDAL> rencontreCreaList;

    public UtilisateurDAL(Long id, String pseudo, LocalDate date, String genre, List<JeuDAL> jeuPreferes, String nom, String prenom, String desc, String telephone, List<AdresseDAL> adresseList, PhotoDAL photo, List<RencontreDAL> rencontreList) {
    }
}
