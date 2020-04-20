package be.ucm.jds.DAL.Entity;

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
    private String password;
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

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private List<JeuDAL> jeuPreferes;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<AdresseDAL> adresseList;

    @ManyToMany(mappedBy = "utilisateurAffList")
    private List<RencontreDAL> rencontreAffList;

    @OneToMany(mappedBy = "utilisateurCrea")
    private List<RencontreDAL> rencontreCreaList;

    @ManyToMany(mappedBy = "utilisateurDALList")
    private List<RoleDAL> roles;
}
