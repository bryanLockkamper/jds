package be.ucm.jds.DAL.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "Jeu")
public class JeuDAL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_jeu;

    @Column(nullable = false)
    private String titre_jeu;
    private String descr_jeu;

    @Column(nullable = false)
    private Integer nbrJoueurMin_jeu;
    private Integer nbrJoueurMax_jeu;

    private String maisonEdition_jeu;
    private Integer ageMin_jeu;

    @ManyToMany
    private List<GenreDAL> genreList_jeu;

    @ManyToMany(mappedBy = "jeuList_rencontre")
    private List<RencontreDAL> rencontreList_jeu;

    @ManyToMany
    private List<UtilisateurDAL> utilisateurList_jeu;


}
