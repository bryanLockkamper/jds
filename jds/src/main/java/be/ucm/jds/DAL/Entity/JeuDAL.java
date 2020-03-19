package be.ucm.jds.DAL.Entity;

import be.ucm.jds.BL.Entity.Genre;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
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


    public JeuDAL(Long id, String titre, String desc, int nbrJoueursMin, int nbrJoueursMax, List<GenreDAL> genreDAL, String maisonEdition, int ageMin) {
        this.id_jeu = id;
        this.titre_jeu = titre;
        this.descr_jeu = desc;
        this.nbrJoueurMin_jeu = nbrJoueursMin;
        this.nbrJoueurMax_jeu = nbrJoueursMax;
        this.maisonEdition_jeu = maisonEdition;
        this.ageMin_jeu = ageMin;
        this.genreList_jeu = genreDAL;
    }
}
